项目总览:
这是一个名为 SRB（尚融宝） 的 P2P 网络借贷平台后端项目，基于 Spring Boot 2.3.4 + MyBatis-Plus + Maven 多模块架构。项目采用经典的三层模块化设计，自底向上依赖关系清晰。

┌──────────────────────────────────────────────────────┐
│                  service-core (核心业务层)              │
│    唯一可启动模块，承载全部P2P借贷业务逻辑               │
│    Controller → Service → Mapper → Database           │
├──────────────────────────────────────────────────────┤
│                  service-base (基础设施层)              │
│    Swagger 配置、公共实体类、ORM框架集成                 │
├──────────────────────────────────────────────────────┤
│                  guigu-common (公共工具层)              │
│    统一响应封装、全局异常处理、错误码、断言工具           │
└──────────────────────────────────────────────────────┘

第一层：guigu-common（公共工具层）
这是项目的"地基"，一个纯工具库模块，不包含任何业务逻辑。它的核心职责有四个方面：

统一响应封装（Result 类）：所有 API 接口统一返回 {code, message, data} 格式的 JSON，通过 Result.success().data("key", val) 链式调用构建响应。

全局异常处理（UnifiedExceptionHandler）：使用 @RestControllerAdvice 拦截所有 Controller 层异常，分为业务异常、SQL 异常、Servlet 异常三层处理，避免向前端暴露堆栈信息。

错误码体系（ResponseEnum）：定义了覆盖全业务线的标准化错误码，从通用服务器错误（-1xx）到参数校验（-2xx）、业务状态（-3xx）、支付（4xx）、短信（-5xx）、微信（-6xx），前后端可据此精确定位问题。

断言工具（Assert）：提供 notNull、isTrue、notEmpty 等静态方法，断言失败时自动抛出 BusinessException，将参数校验从多行 if-else 简化为一行代码。

此外，该模块还通过依赖传递引入了 JWT、fastjson、commons-lang3 等第三方库，供上层模块直接使用。

第二层：service-base（基础设施层）
这是项目的"中间件"层，依赖 guigu-common，为所有业务微服务提供开箱即用的基础能力：

Swagger2 API 文档配置（Swagger2Config）：将 API 文档分为 adminApi（匹配 /admin/.*）和 webApi（匹配 /web/.*）两个分组，任何依赖此模块的服务自动获得 API 文档能力。

公共基础实体类（BaseEntity）：定义了 id（自增主键）、createTime、updateTime、deleted（逻辑删除）四个所有数据库表都应包含的公共字段。

数据访问基础设施：集成了 MySQL 驱动 + MyBatis-Plus + 代码生成器 + Velocity 模板引擎，为上层模块提供 ORM 和代码自动生成能力。

其设计意图很明确——Swagger、MyBatis-Plus、公共实体等配置只写一次，所有业务服务自动继承，避免重复配置。

第三层：service-core（核心业务层）
这是项目中 唯一可独立启动的模块（端口 8084），承载了 P2P 借贷平台的全部业务逻辑。启动类通过 @ComponentScan(basePackages = {"com.hzf.service", "com.hzf"}) 将下层两个模块的 Spring 组件纳入扫描。

领域模型涵盖了完整的 P2P 业务链条：用户体系（UserInfo、UserBind、UserAccount、UserLoginRecord、UserIntegral）→ 借款人认证（Borrower、BorrowerAttach）→ 借款申请（BorrowInfo）→ 标的发布（Lend）→ 投资出借（LendItem）→ 还款回款（LendReturn、LendItemReturn）→ 交易流水（TransFlow），再加上系统级的数据字典（Dict）和积分等级（IntegralGrade），共 16 个实体。

控制层采用双套 API 设计：/admin/core/*（14 个管理端 Controller）面向后台运营人员提供完整 CRUD；/web/core/*（14 个前台 Controller）面向终端用户。两套接口共享同一套 Service 和 Mapper。

业务层的参数校验采用手动校验模式（StringBuilder 收集错误 → 抛出 BusinessException），而非 JSR-303 Bean Validation。所有 Mapper 接口继承 BaseMapper<T>，依赖 MyBatis-Plus 内置 CRUD，暂未编写自定义 SQL。

配置层启用了 MyBatis-Plus 分页插件、逻辑删除、下划线转驼峰映射，连接本地 srb_base 数据库。
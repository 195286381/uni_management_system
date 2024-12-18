# 通用后台管理系统

## 说明
通用后台管理系统. by xzzzzz
适配一般项目情况.

- 采用了前后端分离的单体架构设计
- 软件环境: JDK、MYSQL、Redis、Minio、Maven、Node
- 后端技术选型: Spring Boot, Spring Security, MyBatis, Jwt, Vue3, Element-Plus
- 前端技术选型:
  - 移动端选型: uniapp 
  - PC端选型:
    - Vue2版本: Vue2 Element-UI, Axios, Vuex
    - Vue3版本: Vue3, Element-Plus, Vite, Axios, Pinia
## 快速开始
- | 工具    | 版本说明              |
  |-------|-------------------|
  | 框架    | Spring Boot 2.7.5 |
  | 数据库   | MySQL 8.0         |
  | JDK   | 1.8               |
  | Redis | 3.0               |
  | 构建工具  | Maven 3.8.1       |
  | Node  | 16.13.2           |
- | Minio | 版本待补充             |

## 新增功能.
- 集成jasypt实现配置文件加密
- 集成jsencrypt实现密码加密传输方式
- 集成minio实现文件上传下载
- 添加lombok支持
- 增加knife4j文档
- 增加短信验证码登录(开发中...)
- 增加sso认证(待完成)
- 生成器模版增加导入功能

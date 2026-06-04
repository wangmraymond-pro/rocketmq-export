# 隐私数据检查规则

## 目的

为确保代码仓库中不包含敏感信息，保护用户隐私和系统安全，制定本检查规则。

## 检查范围

所有提交到代码仓库的文件，包括但不限于：
- 源代码文件（.java, .xml, .yml, .json 等）
- 配置文件
- 文档文件
- 脚本文件

## 检查规则

### 1. 配置文件检查

| 检查项 | 检查内容 | 是否允许 |
|--------|----------|----------|
| 数据库连接密码 | 硬编码的数据库密码 | ❌ 禁止 |
| API密钥 | 硬编码的API密钥、AccessKey、SecretKey | ❌ 禁止 |
| Token/密钥 | 硬编码的Token、密钥、证书内容 | ❌ 禁止 |
| 用户名密码 | 硬编码的用户名和密码 | ❌ 禁止 |
| 环境变量占位符 | 使用 `${}` 或空值占位符 | ✅ 允许 |

### 2. 源代码检查

| 检查项 | 检查内容 | 是否允许 |
|--------|----------|----------|
| 密码硬编码 | 代码中直接写密码字符串 | ❌ 禁止 |
| 密钥硬编码 | 代码中硬编码密钥、证书 | ❌ 禁止 |
| 敏感日志输出 | 日志中输出密码、token等 | ❌ 禁止 |
| 配置注入 | 通过配置注入获取敏感信息 | ✅ 允许 |

### 3. 文档检查

| 检查项 | 检查内容 | 是否允许 |
|--------|----------|----------|
| 真实URL/IP | 生产环境URL、IP地址 | ⚠️ 谨慎 |
| 真实账号 | 真实用户名、邮箱、电话 | ❌ 禁止 |
| 示例数据 | 匿名化示例数据 | ✅ 允许 |

### 4. 敏感信息类型清单

以下类型的信息**禁止**出现在代码仓库中：

| 类别 | 示例 |
|------|------|
| 密码 | `password`, `passwd`, `secret`, `pwd` |
| 密钥 | `accessKey`, `secretKey`, `apiKey`, `token` |
| 证书 | `.pem`, `.key`, `.crt`, 证书内容 |
| 凭证 | `credentials`, `auth`, `authorization` |
| 配置 | `jdbc:mysql://...` 带密码的连接串 |
| 个人信息 | 姓名、手机号、邮箱、身份证号 |

## 检查流程

### 代码提交前检查清单

```
□ 1. 检查所有配置文件是否包含硬编码密码/密钥
□ 2. 检查代码中是否有 System.out/日志输出敏感信息
□ 3. 检查文档中是否包含真实生产环境信息
□ 4. 检查是否有未删除的测试数据或调试代码
□ 5. 使用 grep 搜索敏感关键字（password, secret, token, key）
```

### 自动化检查命令

```bash
# 搜索密码相关关键字
grep -r -i "password\|secret\|accesskey\|secretkey" --include="*.java" --include="*.yml" --include="*.xml" .

# 搜索硬编码的URL（可能包含密码）
grep -r "jdbc:" --include="*.yml" --include="*.properties" .

# 搜索base64编码内容（可能是证书）
grep -r "-----BEGIN" .
```

## 违规处理

1. **发现敏感信息**：立即从仓库中删除相关文件或内容
2. **历史提交**：使用 `git filter-branch` 清理历史提交中的敏感信息
3. **密钥泄露**：如果密钥已泄露，立即轮换密钥
4. **通知团队**：通知相关人员进行安全审查

## 最佳实践

### 配置管理

```yaml
# ✅ 推荐：使用环境变量
rocketmq:
  config:
    namesrvAddr: ${NAMESRV_ADDR:}
    accessKey: ${ACCESS_KEY:}
    secretKey: ${SECRET_KEY:}

# ❌ 禁止：硬编码
rocketmq:
  config:
    namesrvAddr: "127.0.0.1:9876"
    accessKey: "mySecretKey"
    secretKey: "mySecretPassword"
```

### 代码示例

```java
// ✅ 推荐：通过配置注入
@Value("${rocketmq.config.accessKey:}")
private String accessKey;

// ❌ 禁止：硬编码
private String accessKey = "mySecretKey";
```

## 责任

所有提交代码的人员都有责任确保提交内容不包含敏感信息。代码审查者应检查每次提交是否符合本规则。

---
**最后更新**：2026-06-04
**适用范围**：所有团队成员

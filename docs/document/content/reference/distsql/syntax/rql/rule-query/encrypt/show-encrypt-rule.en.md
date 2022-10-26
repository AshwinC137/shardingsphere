+++
title = "SHOW ENCRYPT RULES"
weight = 2
+++

### Description

The `SHOW ENCRYPT RULES` syntax is used to query encrypt rules for specified database.

### Syntax

```
ShowEncryptRule::=
  'SHOW' 'ENCRYPT' 'RULES' ('FROM' databaseName)?

databaseName ::=
  identifier
```

### Supplement

- When `databaseName` is not specified, the default is the currently used `DATABASE`. If `DATABASE` is not used, `No database selected` will be prompted.

### Return value description

| Column                    | Description                               |
| ------------------------- | ----------------------------------------  |
| table                     | Logical table name                        |
| logic_column              | Logical column name                       |
| logic_data_type           | Logical column data type                  |
| cipher_column             | Ciphertext column name                    |
| cipher_data_type          | Ciphertext column data type               |
| plain_column              | Plaintext column name                     |
| plain_data_type           | Plaintext column data type                |
| assisted_query_column     | Assisted query column name                |
| assisted_query_data_type  | Assisted query column data type           |
| encryptor_type            | Encryption algorithm type                 |
| encryptor_props           | Encryption algorithm parameter            |
| query_with_cipher_column  | Whether to use encrypted column for query |




### Example

- Query encrypt rules for specified database.

```sql
SHOW ENCRYPT RULES FROM test1;
```

```sql
mysql> SHOW ENCRYPT RULES FROM test1;
+-------------+--------------+-----------------+---------------+------------------+--------------+-----------------+-----------------------+--------------------------+----------------+-------------------------+--------------------------+
| table       | logic_column | logic_data_type | cipher_column | cipher_data_type | plain_column | plain_data_type | assisted_query_column | assisted_query_data_type | encryptor_type | encryptor_props         | query_with_cipher_column |
+-------------+--------------+-----------------+---------------+------------------+--------------+-----------------+-----------------------+--------------------------+----------------+-------------------------+--------------------------+
| t_encrypt   | user_id      |                 | user_cipher   |                  | user_plain   |                 |                       |                          | AES            | aes-key-value=123456abc | true                     |
| t_encrypt   | order_id     |                 | order_cipher  |                  |              |                 |                       |                          | MD5            |                         | true                     |
| t_encrypt_2 | user_id      |                 | user_cipher   |                  | user_plain   |                 |                       |                          | AES            | aes-key-value=123456abc | false                    |
| t_encrypt_2 | order_id     |                 | order_cipher  |                  |              |                 |                       |                          | MD5            |                         | false                    |
+-------------+--------------+-----------------+---------------+------------------+--------------+-----------------+-----------------------+--------------------------+----------------+-------------------------+--------------------------+
4 rows in set (0.00 sec)
```

- Query encrypt rules for current database.

```sql
SHOW ENCRYPT RULES;
```

```sql
mysql> SHOW ENCRYPT RULES;
+-------------+--------------+-----------------+---------------+------------------+--------------+-----------------+-----------------------+--------------------------+----------------+-------------------------+--------------------------+
| table       | logic_column | logic_data_type | cipher_column | cipher_data_type | plain_column | plain_data_type | assisted_query_column | assisted_query_data_type | encryptor_type | encryptor_props         | query_with_cipher_column |
+-------------+--------------+-----------------+---------------+------------------+--------------+-----------------+-----------------------+--------------------------+----------------+-------------------------+--------------------------+
| t_encrypt   | user_id      |                 | user_cipher   |                  | user_plain   |                 |                       |                          | AES            | aes-key-value=123456abc | true                     |
| t_encrypt   | order_id     |                 | order_cipher  |                  |              |                 |                       |                          | MD5            |                         | true                     |
| t_encrypt_2 | user_id      |                 | user_cipher   |                  | user_plain   |                 |                       |                          | AES            | aes-key-value=123456abc | false                    |
| t_encrypt_2 | order_id     |                 | order_cipher  |                  |              |                 |                       |                          | MD5            |                         | false                    |
+-------------+--------------+-----------------+---------------+------------------+--------------+-----------------+-----------------------+--------------------------+----------------+-------------------------+--------------------------+
4 rows in set (0.00 sec)
```

### Reserved word

`SHOW`, `ENCRYPT`, `RULES`, `FROM`

### Related links

- [Reserved word](/en/reference/distsql/syntax/reserved-word/)
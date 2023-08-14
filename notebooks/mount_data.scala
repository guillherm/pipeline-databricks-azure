// Databricks notebook source
dbutils.fs.mkdirs("/mnt/dados")

// COMMAND ----------

// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt/")

// COMMAND ----------

val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "36143c2d-a171-4241-936f-c4afa6dc9f36",
  "fs.azure.account.oauth2.client.secret" -> ".rR8Q~7QRk4pge5gpFkCEvIWBtebr3kOPar30c0Y",
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/82ffb8b2-9858-4d39-a25e-462d9aa29947/oauth2/token")
// Optionally, you can add <directory-name> to the source URI of your mount point.
dbutils.fs.mount(
  source = "abfss://imoveis@guiilhermedatalakecurso.dfs.core.windows.net/",
  mountPoint = "/mnt/dados",
  extraConfigs = configs)


// COMMAND ----------

// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt/dados")

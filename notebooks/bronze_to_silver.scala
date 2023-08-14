// Databricks notebook source
// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt/dados/bronze")

// COMMAND ----------

// MAGIC %md
// MAGIC Lendo os dados da camada bronze

// COMMAND ----------

val path = "dbfs:/mnt/dados/bronze/dataset_imoveis"
val df = spark.read.format("delta").load(path)

// COMMAND ----------

display(df)

// COMMAND ----------

// MAGIC %md
// MAGIC Transformando os campos do json em colunas

// COMMAND ----------

display(
  df.select("anuncio.*","anuncio.endereco.*")
)

// COMMAND ----------

val dados_detalhados = df.select("anuncio.*","anuncio.endereco.*")

// COMMAND ----------

// MAGIC %md
// MAGIC Removendo colunas

// COMMAND ----------

val df_silver = dados_detalhados.drop("caracteristicas","endereco")
display(df_silver)

// COMMAND ----------

// MAGIC %md
// MAGIC Salvando na camada silver

// COMMAND ----------

val path = "dbfs:/mnt/dados/silver/dataset_imoveis"
df_silver.write.format("delta").mode("Overwrite").save(path)

// COMMAND ----------



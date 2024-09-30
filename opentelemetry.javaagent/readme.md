# Architecture

![](docker-compose/architecture.svg)

### main-app

springboot web application

### opentelemetry-javaagent

- opentelemtry javaagent 工具
- version: v2.8.0

### pyroscope-javaagent

- opentelemetry 尚未支援 profiling，先直接使用 pyroscope javaagent 打到 pyroscope 服務上
- 等之後 otel-collector 支援 profiling 後再換

### grafana-otel

- opentelemetry 需要的擴展包支援 span trace

### otel-collector

- opentelemetry 資料收集服務
- 主要工作為接收資料並且轉發到對應的服務上
- 接收 traces, logs, metrics 資料
- traces 打到 Tempo
- logs 打到 Loki
- metrics 打到 Mimir

### loki

- logs 資料存取服務

### mimir

- metrics 資料存取服務

### tempo

- traces 資料存取服務

### grafana

- 資料具現化平台
- 從不同資料來源把資料關聯串接起來
- 從 traces 資料關聯到 logs、metrics、profiling
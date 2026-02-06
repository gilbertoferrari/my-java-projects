# Repositorio para projetos java

```mermaid
graph TD
Root[my-java-projects] --> Worker[app-worker]
Worker --> src[src/main/java]
src --> application[package application]
src --> entities[package entities]
application --> Program
entities --> Department/HourContract
```

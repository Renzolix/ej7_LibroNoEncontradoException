# Ejercicio 7: LibroNoEncontradoException

## Explicación Lógica
1. **Búsqueda Segura:** Evita retornar referencias nulas (`null`) ante búsquedas no coincidentes en una colección `ArrayList`.
2. **Respuesta Explicita:** Si el bucle finaliza sin hallar el elemento, lanza `LibroNoEncontradoException` obligando a la capa superior a gestionar la ausencia.
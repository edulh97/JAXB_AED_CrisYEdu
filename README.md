# CRUD de XML con JAXB

Este proyecto implementa un CRUD (Crear, Leer, Actualizar, Eliminar) utilizando **JAXB** y Java para gestionar datos almacenados en formato XML. 

## Modelo de Datos

El esquema XML que gestiona la aplicación está basado en la siguiente estructura:

```xml
<plataforma_streaming>
    <contenido>
        <titulo>Titulo del contenido</titulo>
        <descripcion>Descripcion del contenido</descripcion>
        <categoria>Categoria de contenido</categoria>
        <creador>Edu</creador>
        <año_publicacion>2025</año_publicacion>
        <clasificacion_edad>18</clasificacion_edad>
    </contenido>
</plataforma_streaming>

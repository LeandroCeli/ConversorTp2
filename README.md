# ConversorTp2
Desarrollar una aplicación móvil en Android (Java ) que permita convertir valores entre Dólares (USD) y Euros (EUR)

# 📱 Conversor de Moneda - MVVM

## 📌 Descripción

Aplicación Android desarrollada en Java que permite convertir valores entre **USD (Dólar)** y **EUR (Euro)** utilizando el patrón de arquitectura **MVVM (Model - View - ViewModel)**.

La aplicación detecta la selección del usuario, realiza la conversión correspondiente y muestra el resultado junto con el tipo de cambio actualizado.

---

##  Funcionalidades

* ✔ Ingreso de monto a convertir
* ✔ Selección de tipo de conversión (USD / EUR)
* ✔ Cálculo automático del resultado
* ✔ Visualización del tipo de cambio actual
* ✔ Posibilidad de modificar el tipo de cambio
* ✔ Validación de datos ingresados
* ✔ Interfaz clara y dinámica

---

##  Arquitectura MVVM

La aplicación implementa el patrón **MVVM**, separando responsabilidades:

### 🔹 Model

Clase `Conversor`

* Contiene la lógica de negocio
* Realiza los cálculos de conversión
* Gestiona el tipo de cambio

---

### 🔹 ViewModel

Clase `ConversorViewModel`

* Intermediario entre la Vista y el Modelo
* Maneja la lógica de conversión
* Utiliza `LiveData` para datos observables
* Formatea los resultados

---

### 🔹 View

Clase `MainActivity`

* Maneja la interfaz gráfica
* Captura eventos del usuario
* Observa los datos del ViewModel
* Muestra resultados en pantalla

---

## ⚙️ Tecnologías utilizadas

* Java
* Android Studio
* ViewBinding
* LiveData
* ViewModel

---

##  Validaciones implementadas

* ✔ Control de campo vacío
* ✔ Validación de entrada numérica
* ✔ Verificación de selección de conversión
* ✔ Manejo de errores para evitar fallos de la aplicación

---

##  Mejoras de UX

* Indicador dinámico de moneda de entrada
* Formato de resultados con dos decimales
* Diálogo para modificar tipo de cambio
* Limpieza automática del campo de entrada

---

## ▶ Cómo ejecutar la aplicación

1. Abrir el proyecto en Android Studio
2. Ejecutar en un emulador o dispositivo físico
3. Ingresar un monto
4. Seleccionar tipo de conversión
5. Presionar "Convertir"

---

## 👥 Integrantes del Grupo

* Celi , Leandro  - 31542704



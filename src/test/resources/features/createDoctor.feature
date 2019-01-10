Feature: Yo como usuario con rol de invitado quiero crear un doctor 

Scenario: Agregar un nuevo doctor al sistema de salud
Given que estoy logueado en la pagina de heruku
When Ingrese la informacion de un nuevo doctor y lo guarde
Then Se debe mostrar el mensaje "Mensaje"
 
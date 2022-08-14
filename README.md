Features:

1. El precio de un viaje se calcula de la siguiente forma: tiempo_viaje x tarifa. Nos piden calcular el precio de los viajes. Por el momento, solo hay que contemplar tiempos de viaje con minutos enteros (por ejemplo: 60, 120, 180... segundos). Por ejemplo:

tiempo de viaje: 900 segundos
tarifa: 0,20€ / minuto
Precio viaje: tiempo_viaje x tarifa = 3€

2. Ahora hay contemplar tiempos de viaje con minutos y segundos (por ejemplo: 2 minutos y 30 segundos, 7 minutos y 15 segundos, etc.). En estos casos, hay que redondear el tiempo de viaje hacia el próximo minuto entero. Por ejemplo:

tiempo de viaje sin redondear: 121 segundos
tiempo de viaje redondeado: 180 segundos
tarifa: 0,20€ / minuto
Precio viaje: tiempo_viaje x tarifa = 0,6€

3. Si el tiempo de viaje es inferior a 1 minuto, el viaje es gratis. Por ejemplo:

tiempo de viaje: 37 segundos
tarifa: 0,20€ / minuto
Precio viaje: 0€

4. Descuento en el precio del viaje. Por ejemplo:

tiempo de viaje sin redondear: 121 segundos
tiempo de viaje redondeado: 180 segundos
tarifa: 0,20€ / minuto
Descuento precio viaje: 20%
Precio viaje: tiempo_viaje x tarifa x 0,8 = 0,48€

5. Descuento en la tarifa. Por ejemplo:

tiempo de viaje sin redondear: 121 segundos
tiempo de viaje redondeado: 180 segundos
tarifa: 0,20€ / minuto
tarifa con 10% de descuento: 0,20€ / minuto x 0,9 = 0,18€ / minuto
Precio viaje: tiempo_viaje x tarifa_con_descuento = 0,54€

6. Si el usuario tiene un pase, se aplica una tarifa a los primeros x minutos del viaje y una tarifa b a partir del minuto x+1. Por ejemplo:

tiempo de viaje sin redondear: 121 segundos
tiempo de viaje redondeado: 180 segundos
tarifa: 0,20€ / minuto
tarifa con 30% de descuento: 0,20€ / minuto x 0,7 = 0,14€ / minuto
pase: primeros 2 minutos a 0,16€ / minuto, el resto a 0,18€ / minuto
Precio viaje: 2×0,16 + 1×0,18 = 0,5€

Notas:

- La tarifa única se ignora
- Si hay descuento en la tarifa única, ese descuento no debe aplicarse a ninguna tarifa del pase.
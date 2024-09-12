PlantUml:

@startuml
class LudotecaSimulacion {
}

class Ludoteca {
}

class List<T> {
}

class Niño {
}

class Aisha {
}

class Node<T> {

}

LudotecaSimulacion --> Ludoteca


Ludoteca --> List
Ludoteca --> Niño
Ludoteca --> Aisha

List --> Node



Aisha --> Niño
Aisha --> List
@enduml


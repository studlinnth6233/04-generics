```
@startuml
package java.lang {
	
    interface Iterable<T> {
    	+Iterator<T> iterator()
    }

	interface Iterator<T> {
    	+boolean hasNext()
        +T next()
    }
}

package de.fhro.inf.prg3.a04 {
enum PlantColor {
	RED,
    YELLOW,
    BLUE,
    ORANGE,
    GREEN
}

class Plant {
	-{static}int instanceCounter
    -int id
    -double height;
    -String family;
    #Plant(PlantColor c, double height, String family)
    +abstract PlantColor getColor()
    +int getId()
    +double getHeight()
    +String getFamily

}

class Flower extends Plant {
	+PlantColor getColor()
}

class Shrub extends Plant {
	+PlantColor getColor()
}

class PlantBed<T extends Plant> implements Iterable {
	-Element<T> head;

	PlantBed<? extends T> filter(SimpleFilter<T> filter)
    void forEachMatching(SimpleFilter<T> filter, Consumer<? super T> consumer)
    List<T> getPlantsWithColor(PlantColor pc)
}

-class Element<T extends Plant> {
	-T item
    -Element<T> next;
    
    +T getItem()
    +Element<T> getNext()
    +void setNext(Element<T> e)
}

abstract class PlantUtility {
	+{static}Map<Color, ? super Plant> splitByColor(PlantBed<T extends Plant>)
}

}
@enduml
```
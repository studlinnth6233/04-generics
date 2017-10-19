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

    package de.fhro.inf.prg3.a04.collections {
        interface SimpleFilter<T> {
            +include(T item): boolean
        }

        interface SimpleList<T> extends Iterable {
            +add(T item)
            +addEmpty()
            +size(): int
            +filter(SimpleFilter<T> filter): SimpleList
        }

        class SimpleListImpl<T> implements SimpleList {
           -head: Element
        }

        class SimpleIteratorImpl implements Iterator {
        }

        -class Element<T> {
        	-T item
            -Element<T> next;
    
            +T getItem()
            +Element<T> getNext()
            +void setNext(Element<T> e)
        }

        SimpleListImpl +-- Element : nested
        Element o-- SimpleListImpl : head
    }

    package de.fhro.inf.prg3.a04.models {
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
            #Plant(double height, String family)
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
    }

    class PlantBed {

	    -plants: SimpleList<Plant>

        +add(Plant p)
        +getPlants(): SimpleList<Plant>
        +getPlantsWithColor(PlantColor pc): SimpleList<T>
    }

    abstract class PlantUtility {
	    +{static}splitByColor(PlantBed plantBed): Map<PlantColor, SimpleList<Plant>> 
    }

}
@enduml
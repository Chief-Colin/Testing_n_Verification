package tests;

import org.junit.Before;
import org.mockito.Mock;
import vehicle.controller.Car;
import vehicle.controller.MockActuator;
import vehicle.model.Actuator;

import static org.mockito.Mockito.mock;

public class CarScenarios {
    private Car car;
    private MockActuator engine;

    @Mock
    Actuator actuator =  mock(Actuator.class);

    @Before
    public void setUp() {
        car = new Car(engine);
    }
    
}

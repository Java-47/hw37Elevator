package telran.truck.task;

import telran.truck.model.Elevator;

public class Truck implements Runnable {
	int nRaces;
	int capacity;
	Elevator elevator;
	Elevator elevator2;

	public Truck(int nRaces, int capacity, Elevator elevator, Elevator elevator2) {
		this.nRaces = nRaces;
		this.capacity = capacity;
		this.elevator = elevator;
		this.elevator2 = elevator2;
	}

	@Override
	public void run() {
		for (int i = 0; i < nRaces; i++) {
			synchronized (elevator) {
				elevator.add(capacity / 2);
			}
			synchronized (elevator2) {
				elevator2.add(capacity / 2 + capacity % 2);
			}
		}

	}

}

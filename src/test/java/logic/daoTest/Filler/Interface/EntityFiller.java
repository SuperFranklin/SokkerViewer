package test.java.logic.daoTest.Filler.Interface;

import main.java.logic.Interfaces.Identifiable;

public interface EntityFiller<T extends Identifiable>
{
	public T fill();
}

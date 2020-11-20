package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit unit;

		try {
			Class<? extends AbstractUnit> clazz =
					(Class<? extends AbstractUnit>) Class.forName(UNITS_PACKAGE_NAME + unitType);

			Constructor<? extends AbstractUnit> ctor = clazz.getDeclaredConstructor();

			unit = ctor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			throw new IllegalStateException(e);
		}

		return unit;
	}
}

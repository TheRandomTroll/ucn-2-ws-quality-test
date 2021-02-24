package test;

import org.junit.*;
import static org.junit.Assert.*;

import controllayer.*;
import modellayer.Currency;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik B�rbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestCalculationCurrencyDkk {

	ControlPayStation ps;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	@Test
	public void shouldDisplay27MinFor5Dkk() throws IllegalCoinException {

		int expectedParkingTime = 27;
		int coinValue = 5;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;

		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);

		// Assert
		assertEquals("Should display 27 min for 5 DKK", expectedParkingTime, ps.readDisplay());
	}

	@Test
	public void shouldDisplay160MinFor30Dkk() throws IllegalCoinException {
		int expectedParkingTime = 160;
		int coinValue = 20;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;

		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		
		coinValue = 10;
		ps.addPayment(coinValue, coinCurrency, coinType);

		// Assert
		assertEquals("Should display 160 min for 30 DKK", expectedParkingTime, ps.readDisplay());
	}

	/** Fixture for pay station testing. */
	@After
	public void cleanUp() {
		ps.setReady();
	}

}

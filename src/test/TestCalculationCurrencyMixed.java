package test;

import org.junit.*;
import static org.junit.Assert.*;

import controllayer.*;
import modellayer.*;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik B�rbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestCalculationCurrencyMixed {

	ControlPayStation ps;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	@Test
	public void shouldDisplay107MinFor2EurAnd5Dkk() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 107; // In minutes
		int coinValue = 5;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;

		// Act

		ps.addPayment(coinValue, coinCurrency, coinType);

		coinValue = 2;
		coinCurrency = Currency.ValidCurrency.EURO;
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 107 mins for 2 Euro and 5 DKK", expectedParkingTime, ps.readDisplay());
	}

	@Test
	public void shouldDisplay220MinutesFor2Eur50Centand22Dkk50Ore() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 220; // In minutes
		int coinValue = 20;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;

		// Act

		ps.addPayment(coinValue, coinCurrency, coinType);

		coinValue = 50;
		coinCurrency = Currency.ValidCurrency.EURO;
		coinType = Currency.ValidCoinType.FRACTION;
		ps.addPayment(coinValue, coinCurrency, coinType);
		
		coinValue = 50;
		coinCurrency = Currency.ValidCurrency.DKK;
		ps.addPayment(coinValue, coinCurrency, coinType);
		
		coinValue = 2;
		coinCurrency = Currency.ValidCurrency.EURO;
		coinType = Currency.ValidCoinType.INTEGER;
		ps.addPayment(coinValue, coinCurrency, coinType);
		
		coinCurrency = Currency.ValidCurrency.DKK;
		ps.addPayment(coinValue, coinCurrency, coinType);
		
		// Assert
		assertEquals("Should display 220 mins for 2 Euro, 50 cent, 22 DKK and 50 ore", expectedParkingTime, ps.readDisplay());
	}

	/** Fixture for pay station testing. */
	@After
	public void cleanUp() {
		ps.setReady();
	}

}

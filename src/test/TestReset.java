package test;

import org.junit.*;
import static org.junit.Assert.*;

import controllayer.*;
import modellayer.*;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik B�rbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestReset {

	ControlPayStation ps;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	/**
	 * Verify that the pay station is cleared and display shows 0 after a buy
	 * scenario
	 */
	@Test
	public void shouldClearAfterBuy() throws IllegalCoinException, Exception {
		int expectedParkingTime = 27;
		int coinValue = 5;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;

		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);

		// Assert
		assertEquals("Should display 27 min for 5 DKK", expectedParkingTime, ps.readDisplay());

		expectedParkingTime = 0;
		ps.buy();

		assertEquals("Should display 0 min when the BUY button is pressed", expectedParkingTime, ps.readDisplay());

	}

	/**
	 * Verify that cancel() clears the pay station
	 */
	@Test
	public void shouldClearAfterCancel() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 2; // In minutes
		int coinValue = 5;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;

		// Act

		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert

		assertEquals("Should display 2 mins for 5 cents", expectedParkingTime, ps.readDisplay());

		expectedParkingTime = 0;
		
		ps.cancel();
		
		assertEquals("Should display 0 min when the CANCEL button is pressed", expectedParkingTime, ps.readDisplay());
	}
}

package test;

import org.junit.*;

import controllayer.*;
import modellayer.Currency;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik B�rbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestIllegalCoin {

	ControlPayStation ps;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	/**
	 * Verify that illegal coins are rejected.
	 */

	// Norwegian coin
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalCurrencyNokCoin() throws IllegalCoinException {
		int coinValue = 1;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.NOK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;

		ps.addPayment(coinValue, coinCurrency, coinType);
	}

	// unknown Euro coin value
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalEuroCoin() throws IllegalCoinException {
		int coinValue = 3;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;

		ps.addPayment(coinValue, coinCurrency, coinType);
	}

	// unknown Euro fraction value
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalEuroCoinFraction() throws IllegalCoinException {
		int coinValue = 37;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;

		ps.addPayment(coinValue, coinCurrency, coinType);
	}

	// unknown Euro coin value
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalDKKCoin() throws IllegalCoinException {
		int coinValue = 30;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;

		ps.addPayment(coinValue, coinCurrency, coinType);
	}

	// unknown Euro fraction value
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalDKKCoinFraction() throws IllegalCoinException {
		int coinValue = 72;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;

		ps.addPayment(coinValue, coinCurrency, coinType);
	}
}

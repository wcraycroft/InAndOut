package cs134.miracosta.edu.Model;

/**
 * Calculation module for an order at In And Out Restaurant, using preset menu item prices
 * to calculate the subtotal, tax and total costs.
 *
 * @author William Craycroft
 */
public class Order {
    // Constants
    /** The price of a Cheeseburger*/
    public static final double PRICE_CHEESEBURGER = 2.15;
    /** The price of a Double Double*/
    public static final double PRICE_DOUBLE_DOUBLE = 3.6;
    /** The price of an order of French Fries */
    public static final double PRICE_FRENCH_FRIES = 1.65;
    /** The price of a Shake*/
    public static final double PRICE_SHAKE = 2.2;
    /** The price of a Small Fountain Drink*/
    public static final double PRICE_SMALL_DRINK = 1.45;
    /** The price of a Medium Fountain Drink*/
    public static final double PRICE_MEDIUM_DRINK = 1.55;
    /** The price of a Large Fountain Drink*/
    public static final double PRICE_LARGE_DRINK = 1.75;
    /** The current (approximate) Oceanside, CA tax rate*/
    public static final double TAX_RATE = 0.08;

    // Instance Variables
    /** The number of Cheeseburgers in the order*/
    private int mCheeseburgers = 0;
    /** The number of Double Doubles in the order*/
    private int mDoubleDoubles = 0;
    /** The number of French Fries in the order*/
    private int mFrenchFries = 0;
    /** The number of Shakes in the order*/
    private int mShakes = 0;
    /** The number of Small Fountain Drinks in the order*/
    private int mSmallDrinks = 0;
    /** The number of Medium Fountain Drinks in the order*/
    private int mMediumDrinks = 0;
    /** The number of Large Fountain Drinks in the order*/
    private int mLargeDrinks = 0;

    // Getters
    /**
     * Gets the number of Cheeseburgers in the current order.
     * @return mCheeseburgers The number of Cheeseburgers.
     */
    public int getCheeseburgers() {
        return mCheeseburgers;
    }
    /**
     * Gets the number of Double Doubles in the current order.
     * @return mDoubleDoubles The number of Double Doubles.
     */
    public int getDoubleDoubles() {
        return mDoubleDoubles;
    }
    /**
     * Gets the number of French Fries in the current order.
     * @return mFrenchFries The number of French Fries.
     */
    public int getFrenchFries() {
        return mFrenchFries;
    }
    /**
     * Gets the number of Shakes in the current order.
     * @return mShakes The number of Shakes.
     */
    public int getShakes() {
        return mShakes;
    }
    /**
     * Gets the number of Small Drinks in the current order.
     * @return mSmallDrinks The number of Small Drinks.
     */
    public int getSmallDrinks() {
        return mSmallDrinks;
    }
    /**
     * Gets the number of Medium Drinks in the current order.
     * @return mMediumDrinks The number of Medium Drinks.
     */
    public int getMediumDrinks() {
        return mMediumDrinks;
    }
    /**
     * Gets the number of Large Drinks in the current order.
     * @return mLargeDrinks The number of Large Drinks.
     */
    public int getLargeDrinks() {
        return mLargeDrinks;
    }

    // Setters
    /**
     * Sets the number of Cheeseburgers in the current order.
     * @param cheeseburgers The number of Cheeseburgers.
     */
    public void setCheeseburgers(int cheeseburgers) {
        mCheeseburgers = cheeseburgers;
    }
    /**
     * Sets the number of Double Doubles in the current order.
     * @param doubleDoubles The number of Double Doubles.
     */
    public void setDoubleDoubles(int doubleDoubles) {
        mDoubleDoubles = doubleDoubles;
    }
    /**
     * Sets the number of French Fries in the current order.
     * @param frenchFries The number of French Fries.
     */
    public void setFrenchFries(int frenchFries) {
        mFrenchFries = frenchFries;
    }
    /**
     * Sets the number of Shakes in the current order.
     * @param shakes The number of Shakes.
     */
    public void setShakes(int shakes) {
        mShakes = shakes;
    }
    /**
     * Sets the number of Small Drinks in the current order.
     * @param smallDrinks The number of Small Drinks.
     */
    public void setSmallDrinks(int smallDrinks) {
        mSmallDrinks = smallDrinks;
    }
    /**
     * Sets the number of Medium Drinks in the current order.
     * @param mediumDrinks The number of Medium Drinks.
     */
    public void setMediumDrinks(int mediumDrinks) {
        mMediumDrinks = mediumDrinks;
    }
    /**
     * Sets the number of Large Drinks in the current order.
     * @param largeDrinks The number of Large Drinks.
     */
    public void setLargeDrinks(int largeDrinks) {
        mLargeDrinks = largeDrinks;
    }

    // Helper methods
    /**
     * Calculates the subtotal for the current order by taking the sum of each item multiplied
     * by its constant price.
     * @return The subtotal of the current order.
     */
    public double calculateSubtotal() {
        return mCheeseburgers * PRICE_CHEESEBURGER
                + mDoubleDoubles * PRICE_DOUBLE_DOUBLE
                + mFrenchFries * PRICE_FRENCH_FRIES
                + mShakes * PRICE_SHAKE
                + mLargeDrinks * PRICE_LARGE_DRINK
                + mMediumDrinks * PRICE_MEDIUM_DRINK
                + mSmallDrinks * PRICE_SMALL_DRINK;
    }

    /**
     * Calculates the tax due for the current order by multiplying the subtotal by the current tax rate.
     * @return The tax due for the current order.
     */
    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    /**
     * Calculates the total due for the current order by adding the tax due to the subtotal.
     * @return The total due for the current order.
     */
    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    /**
     * Calculates the number of items in the order by taking the sum of all instance variables.
     * @return The number of items in the order.
     */
    public int getNumberItemsOrdered() {
        return mCheeseburgers + mDoubleDoubles + mFrenchFries + mShakes + mLargeDrinks
                + mMediumDrinks + mSmallDrinks ;
    }
}

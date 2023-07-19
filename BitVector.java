import java.util.ArrayList;

/**
 * The BitVector class represents a bit vector that allows setting and resetting bits at specified positions.
 * It uses an ArrayList to store the bits, and each element in the ArrayList corresponds to a 64-bit block.
 * The bits are addressed by position, and the position is zero-based.
 */

public class BitVector {
    private int arraySize;
    private int position;
    private int elementIndex;
    private int bitPosition;
    private final int BIT_STEP = 64;
    private int size = bitVector.size();
    private final static ArrayList<Integer> BIT_VECTOR;
    static
    {
       BIT_VECTOR = new ArrayList<>();
    }

    /**
     * Checks if the size of the bitVector ArrayList is greater than or equal to the required array size.
     * @return true if the size is greater than or equal to the required array size, false otherwise.
     */
    
    private boolean checkArraySize() {
        return BIT_VECTOR.size() >= arraySize;
    }

    /**
     * Calculates the required array size based on the current position and sets the elementIndex and arraySize fields accordingly.
     */
    
    private void countArraySize() {
        if (position % BIT_STEP == 0) {
            this.elementIndex = this.arraySize = position / BIT_STEP;
        } else {
            this.elementIndex = this.arraySize = position / BIT_STEP + 1;
        }
    }

    
    /**
     * Adds zero elements to the beginning of the bitVector ArrayList to match the required array size.
     */
    
    private void setBitVectorElementInFront() {
        int temp = arraySize;
        while (temp - size > 0) {
            BIT_VECTOR.add(0,0);
            --temp;
        }
    }

    /**
     * Adds zero elements to the end of the bitVector ArrayList to match the required array size.
     */
    
    private void setBitVectorElement() {
        int temp = arraySize;
        while (temp > 0) {
            BIT_VECTOR.add(0);
            --temp;
        }
    }

    /**
     * Sets the position value.
     * @param pos The position value to set.
     * @throws ArrayIndexOutOfBoundsException if the given position is negative.
     */
    
    private void setPositionValue(int pos) {
        if (pos >= 0)
          this.position = pos;
        System.out.println("Invalid input.");
        System.exit(-1);
    }

    /**
     * Checks if the given position value is valid (non-negative).
     * @param pos The position value to check.
     * @return true if the position value is valid (non-negative), false otherwise.
     */
    
    private boolean checkPositionValue(int pos) {
        return pos >= 0;
    }

    /**
     * Prints the content of the bitVector ArrayList before setting a bit.
     */
    
    private void printBitVectorBeforeSet() {
        System.out.println("The BIT_VECTOR before setting: ");
        for (int el : BIT_VECTOR) {
            System.out.print(Integer.toString(el, 2));
        }
    }

    /**
     * Prints the content of the bitVector ArrayList after setting a bit.
     */
    
    private void printBitVectorAfterSet() {
        System.out.println("The BIT_VECTOR After setting: ");
        for (int el : BIT_VECTOR) {
            System.out.print(Integer.toString(el, 2) + " ");
        }
    }

    
    /**
     * Finds the corresponding bit position in the element based on the current position.
     */
    
    private void findBitPositionInElement() {
        if (position > BIT_STEP) {
            bitPosition = position;
            bitPosition -= BIT_STEP;
                while (!(bitPosition < BIT_STEP)) {
                    bitPosition -= BIT_STEP;
                }
        } else {
            bitPosition = BIT_STEP - position;
        }
    }

     /**
     * Sets the bit at the given position to 1.
     * @param pos The position of the bit to be set.
     * @throws ArrayIndexOutOfBoundsException if the position is negative or greater than the allowed maximum.
     */
    
    public void set(int pos) {
        if (BIT_VECTOR.isEmpty()) {
            setBitVectorElement();
        }
        if (!BIT_VECTOR.isEmpty()) {
            if (checkPositionValue(pos)) {
                setPositionValue(pos);
                countArraySize();
                if (checkArraySize()) {
                    findBitPositionInElement();
                    BIT_VECTOR.set(elementIndex, BIT_VECTOR.get(elementIndex) | (1 << bitPosition));
                } else {
                    setBitVectorElementInFront();
                    findBitPositionInElement();
                    BIT_VECTOR.set(elementIndex, BIT_VECTOR.get(elementIndex) | (1 << bitPosition));
                }
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    /**
     * Resets the bit at the given position to 0.
     * @param pos The position of the bit to be reset.
     * @throws ArrayIndexOutOfBoundsException if the position is negative or greater than the allowed maximum.
     */
    
    public void reset(int pos) {
        if (BIT_VECTOR.isEmpty()) {
           System.out.println("BIT_VECTOR is empty.");
           System.exit(1);
        }
        if (!BIT_VECTOR.isEmpty()) {
            if (checkPositionValue(pos)) {
                countArraySize();
                if (checkArraySize()) {
                    findBitPositionInElement();
                    BIT_VECTOR.set(elementIndex, BIT_VECTOR.get(elementIndex) & (~(1 << bitPosition)));
                } else {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
        }
    }
}

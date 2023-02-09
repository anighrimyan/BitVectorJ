import java.util.ArrayList;
public class BitVector {
    private int arraySize;
    private int position;
    private int elementIndex;
    private int bitPosition;
    private final int bitStep = 64;
    int size = bitVector.size();
    private final static ArrayList<Integer> bitVector;
    static
    {
        bitVector = new ArrayList<>();
    }
    private boolean checkArraySize() {
        return bitVector.size() >= arraySize;
    }
    private void countArraySize() {
        if (position % bitStep == 0) {
            this.elementIndex = this.arraySize = position / bitStep;
        } else {
            this.elementIndex = this.arraySize = position / bitStep + 1;
        }
    }
    private void setBitVectorElementInFront() {
        int temp = arraySize;
        while (temp - size > 0) {
            bitVector.add(0,0);
            --temp;
        }
    }
    private void setBitVectorElement() {
        int temp = arraySize;
        while (temp > 0) {
            bitVector.add(0);
            --temp;
        }
    }
    private void setPositionValue(int pos) {
        if (pos >= 0)
          this.position = pos;
        System.out.println("Invalid input.");
        System.exit(-1);
    }
    private boolean checkPositionValue(int pos) {
        return pos >= 0;
    }
    private void printBitVectorBeforeSet() {
        System.out.println("The bitVector before setting: ");
        for (int el : bitVector) {
            System.out.print(Integer.toString(el, 2));
        }
    }
    private void printBitVectorAfterSet() {
        System.out.println("The bitVector After setting: ");
        for (int el : bitVector) {
            System.out.print(Integer.toString(el, 2) + " ");
        }
    }
    private void findBitPositionInElement() {
        if (position > bitStep) {
            bitPosition = position;
            bitPosition -= bitStep;
                while (!(bitPosition < bitStep)) {
                    bitPosition -= bitStep;
                }
        } else {
            bitPosition = bitStep - position;
        }
    }
    public void set(int pos) {
        if (bitVector.isEmpty()) {
            setBitVectorElement();
        }
        if (!bitVector.isEmpty()) {
            if (checkPositionValue(pos)) {
                setPositionValue(pos);
                countArraySize();
                if (checkArraySize()) {
                    findBitPositionInElement();
                    bitVector.set(elementIndex, bitVector.get(elementIndex) | (1 << bitPosition));
                } else {
                    setBitVectorElementInFront();
                    findBitPositionInElement();
                    bitVector.set(elementIndex, bitVector.get(elementIndex) | (1 << bitPosition));
                }
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }
    public void reset(int pos) {
        if (bitVector.isEmpty()) {
           System.out.println("bitVector is empty.");
           System.exit(1);
        }
        if (!bitVector.isEmpty()) {
            if (checkPositionValue(pos)) {
                countArraySize();
                if (checkArraySize()) {
                    findBitPositionInElement();
                    bitVector.set(elementIndex, bitVector.get(elementIndex) & (~(1 << bitPosition)));
                } else {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
        }
    }
}

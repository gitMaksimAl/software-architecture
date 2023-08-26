package Lesson_4.Homework_4.TicketService;

public class CashProvider {

    private long card;
    private long hashCard = 17;
    public boolean isAithorization = false;

    public CashProvider(long cardNumber) {
        this.card = cardNumber;
        this.hashCard *= 31 + String.valueOf(cardNumber).hashCode();
    }

    public boolean getMoney(double price) throws ContractException{
        if (price <= 0.0) throw new ContractException("Not valid price.");
        else return (this.isAithorization);
    }

    /**
     * check card with hashcode
     * @param cardNumber
     * @throws ContractException
     */
    public void autorization(long cardNumber) throws ContractException{
        long hash = 17;
        if (this.hashCard == (hash  *= 31 + String.valueOf(cardNumber).hashCode()))
            this.isAithorization = true;
        else throw new ContractException("Authotization not passed.");
    }

    public long getCard() {
        return card;
    }

    @Override
    public String toString() {
        return String.valueOf(this.card);
    }
}

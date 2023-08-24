package Lesson_4.Homework_4.TicketService;

public class CashProvider {

    private long card;
    private long hashCard = 17;
    public boolean isAithorization = false;

    public CashProvider(long cardNumber) {
        this.card = cardNumber;
        this.hashCard *= 31 + String.valueOf(cardNumber).hashCode();
    }

    public boolean getMoney(double price) throws ServiceException{
        if (price <= 0.0) throw new ServiceException("Not valid price.");
        else return (this.isAithorization);
    }

    // TODO:
    // params not match with diagram
    public void autorization(long cardNumber) throws ServiceException{
        if (this.hashCard == 17 * (31 + String.valueOf(cardNumber).hashCode()))
            this.isAithorization = true;
        else throw new ServiceException("Authotization not passed.");
    }

    public long getCard() {
        return card;
    }

    @Override
    public String toString() {
        return String.valueOf(this.card);
    }
}

package user;

public class MySavingCreationCallback implements SavingCreationCallback {
    private long initialSavingBalance;

    @Override
    public void onSavingCreated(long initialSavingBalance) {
        this.initialSavingBalance = initialSavingBalance;
    }

    public final long getInitialSavingBalance() {
        return initialSavingBalance;
    }
}

package src;

public interface Navigator {
    void showInventory();
    void showCaseSelection();
    void startCaseOpening(Case selectedCase);
    void showResult(CaseItem wonItem);
}

package Image;

public class AddFilters {

    Tools tools = new Tools();

    public boolean CalcFilter(int R, int B, int G) {
        int S0 = 0, S4 = 0;
        if (tools.isCheckedCh1 && tools.isCheckedCh2) {
            S0 = (int) Math.ceil(-0.0009 * G * G + 1.1917 * G - 4.0146);
            S4 = (int) Math.ceil(-0.0011 * G * G + 1.2262 * G + 4.0264);
        }
        if (tools.isCheckedCh1 && tools.isCheckedCh3) {
            S0 = (int) Math.ceil(-0.0009 * G * G + 1.1917 * G - 4.0146);
            S4 = (int) Math.ceil(-0.0013 * G * G + 1.2608 * G + 12.067);
        }
        if (tools.isCheckedCh1 && tools.isCheckedCh4) {
            S0 = (int) Math.ceil(-0.0009 * G * G + 1.1917 * G - 4.0146);
            S4 = (int) Math.ceil(-0.0026 * G * G + 1.5713 * G + 14.8);
        }
        if (tools.isCheckedCh2 && tools.isCheckedCh3) {
            S0 = (int) Math.ceil(-0.0011 * G * G + 1.2262 * G + 4.0264);
            S4 = (int) Math.ceil(-0.0013 * G * G + 1.2608 * G + 12.067);
        }
        if (tools.isCheckedCh2 && tools.isCheckedCh4) {
            S0 = (int) Math.ceil(-0.0011 * G * G + 1.2262 * G + 4.0264);
            S4 = (int) Math.ceil(-0.0026 * G * G + 1.5713 * G + 14.8);

        }

        int mid = (R + B) / 2;
        if (!tools.isCheckedCh0) {
            if (S0 <= mid && mid <= S4) {
                return true;
            } else
                return false;
        } else {
            if (S0 <= mid && mid <= S4) {
                return false;
            } else
                return true;
        }

    }

}
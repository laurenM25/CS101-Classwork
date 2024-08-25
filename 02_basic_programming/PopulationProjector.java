public class PopulationProjector {
    public static void main(String[] args) {

        int initialPopulation = 334300850;

        double addBDay = 86400 / 9; // births per day
        double addMDay = 86400 / 32; // immigrants per day
        double subDay = 86400 / 10; // deaths per day
        int years = 1;

        System.out.println("Here are the projected population numbers for the next five years:");

        while (years <= 5) {
            double PopulationChange = (addBDay + addMDay - subDay) * 365 * years;
            int FinalPopulation = (int) Math.round(initialPopulation + PopulationChange);

            System.out.println("- Year " + (2023 + years) + ": " + FinalPopulation);
            years++;
        }
    }
}

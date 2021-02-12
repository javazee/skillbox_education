public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float [] patientsTemperatures = new float[patientsCount];
        for (int i = 0; i < patientsTemperatures.length; i++){
            patientsTemperatures[i] = (float) Math.round((Math.random() * (40 -32) + 32) * 10) / 10;
        }
        return patientsTemperatures;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        float sum = 0;
        int healthySum = 0;
        String allTemperature = "";
        for (int i = 0; i < temperatureData.length; i++){
            sum = sum + temperatureData[i];
            allTemperature = allTemperature + " " + temperatureData[i];
            if (temperatureData[i] > 36.1 && temperatureData[i] < 37){
                healthySum++;
            }
        }
        float averageTemperature = (float) Math.round((sum / temperatureData.length) * 100) / 100;
        String report =
                "Температуры пациентов:" + allTemperature +
                        "\nСредняя температура: " + averageTemperature +
                        "\nКоличество здоровых: " + healthySum;

        return report;
    }
}

package dto.consumption;

import java.time.LocalDate;
import java.util.List;

public class Consumption {
    LocalDate date;
    String employeeResponsible;
    int accommodationNumber;
    List<ConsumptionItens> consumptionItens;
    List<Integer> quantityItens;
    double totalValue;
}

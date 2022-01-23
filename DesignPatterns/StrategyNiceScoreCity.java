package DesignPatterns;

import enums.Category;
import enums.Cities;
import main.Child;
import main.Gift;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static enums.Cities.BRAILA;
import static enums.Cities.BRASOV;
import static enums.Cities.BUCURESTI;
import static enums.Cities.BUZAU;
import static enums.Cities.CLUJ;
import static enums.Cities.CONSTANTA;
import static enums.Cities.CRAIOVA;
import static enums.Cities.IASI;
import static enums.Cities.ORADEA;
import static enums.Cities.TIMISOARA;

public class StrategyNiceScoreCity implements StrategyForAssGifts {
    private final double maxPrice = 100000;

    /**
     * @param children
     * @param santaGifts
     * @return
     */
    @Override
    public List<Child> assGifts(final List<Child> children, final List<Gift> santaGifts) {
        List<AuxiliaryCityClass> cityList = createCityList();

        //calculez avscore pt fiecare oras
        for (AuxiliaryCityClass iterCityList : cityList) {
            Double avCityScore = averageCityScore(children, iterCityList.getCity());
            iterCityList.setAverageCityScore(avCityScore);
        }

        //sortez orasele in fct de av score si lexico
        Comparator<AuxiliaryCityClass> avScoreCityComparator =
                Comparator.comparing((AuxiliaryCityClass a) ->
                        a.getAverageCityScore()).reversed().thenComparing(a
                        -> a.getCity().toString());
        Collections.sort(cityList, avScoreCityComparator);

        Collections.sort(children); //ma asigur ca lista de copii e sortata in fct de id

        //distribuim cadourile
        for (AuxiliaryCityClass iterCity : cityList) {
            for (Child iterChild : children) {
                if (iterChild.getCity().equals(iterCity.getCity())) {
                    iterChild.setReceivedGifts(findTheGift(iterChild, santaGifts));
                }
            }
        }

        return children;
    }

    /**
     * @param children
     * @param city
     * @return
     */
    public Double averageCityScore(final List<Child> children, final Cities city) {

        Collections.sort(children);
        Double res = 0.0;
        int nrOfCh = 0;
        for (Child iterChild : children) {
            if (iterChild.getCity().equals(city)) {
                res += iterChild.getAverageScore();
                nrOfCh++;
            }
        }
        if (nrOfCh != 0) {
            res /= nrOfCh;
        }
        return res;

    }

    /**
     * @return
     */
    public List<AuxiliaryCityClass> createCityList() {
        List<AuxiliaryCityClass> cityList = new ArrayList<>();
        AuxiliaryCityClass city;

        city = new AuxiliaryCityClass(BUCURESTI, 0.0);
        cityList.add(city);

        city = new AuxiliaryCityClass(CONSTANTA, 0.0);
        cityList.add(city);

        city = new AuxiliaryCityClass(BUZAU, 0.0);
        cityList.add(city);

        city = new AuxiliaryCityClass(TIMISOARA, 0.0);
        cityList.add(city);

        city = new AuxiliaryCityClass(CLUJ, 0.0);
        cityList.add(city);

        city = new AuxiliaryCityClass(IASI, 0.0);
        cityList.add(city);

        city = new AuxiliaryCityClass(CRAIOVA, 0.0);
        cityList.add(city);

        city = new AuxiliaryCityClass(BRASOV, 0.0);
        cityList.add(city);

        city = new AuxiliaryCityClass(BRAILA, 0.0);
        cityList.add(city);

        city = new AuxiliaryCityClass(ORADEA, 0.0);
        cityList.add(city);

        return cityList;

    }


    /**
     * @param child
     * @param santaGifts
     * @return
     */
    @Override
    public List<Gift> findTheGift(final Child child, final List<Gift> santaGifts) {
        List<Gift> gifts = new ArrayList<>();

        double budget = child.getBudget();

        for (Category cat : child.getGiftsPreferences()) {
            Gift theCheapest = new Gift();
            Double cheapest = maxPrice;
            for (Gift gift : santaGifts) {
                if (gift.getCategory().equals(cat)) {
                    if (gift.getPrice() < cheapest && gift.getQuantity() > 0) {
                        cheapest = gift.getPrice();
                        theCheapest = gift;
                    }
                }
            }
            if (cheapest != maxPrice) {
                if (budget >= theCheapest.getPrice()) {
                    budget -= theCheapest.getPrice();
                    int quantity = theCheapest.getQuantity();
                    theCheapest.setQuantity(quantity - 1);
                    gifts.add(theCheapest);
                }
            }
        }
        return gifts;
    }
}

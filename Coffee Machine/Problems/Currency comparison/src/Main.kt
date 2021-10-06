enum class CurrencyComparison(val country: String, val currency: String) {
    GERMANY("Germany", "Euro"),
    MALI("Mali", "CFA franc"),
    DOMINICA("Dominica", "Eastern Caribbean dollar"),
    CANADA("Canada", "Canadian dollar"),
    SPAIN("Spain","Euro"),
    AUSTRALIA("Australia", "Australian dollar"),
    BRAZIL("Brazil", "Brazilian real"),
    SENEGAL("Senegal", "CFA franc"),
    FRANCE("France", "Euro"),
    GRENADA("Grenada", "Eastern Caribbean dollar"),
    KIRIBATI("Kiribati", "Australian dollar"),
    NULL("","");

    companion object {
        fun findByCountry(rgb: String): CurrencyComparison {
            for (enum in CurrencyComparison.values()) {
                if (rgb == enum.country) return enum
            }
            return NULL
        }
    }
}


fun main() {

    val (firstCountry, secondCountry) = readLine()!!.split(" ")

    val currency1 = CurrencyComparison.findByCountry(firstCountry).currency
    val currency2 = CurrencyComparison.findByCountry(secondCountry).currency

    if ((currency1 == "") || (currency2 == "")) print(false) else if (currency1 == currency2) print(true) else print(false)

}
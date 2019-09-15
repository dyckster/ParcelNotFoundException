package com.parcelnotfoundexception.javahack.domain.model.timeline

data class TotalAmount(
    val monthlyCredit: List<YearlySum>,
    val monthlyDebit: List<YearlySum>,
    val monthlyTax: List<YearlySum>
) {

    fun getMonthlyCredit() = monthlyCredit.first()
    fun getMonthlyDebit() = monthlyDebit.first()
    fun getMonthlyTax() = monthlyTax.first()

    fun getMaxAvailableMonths(): List<String> {
        val linkedSet: MutableSet<String> = HashSet()
        val allList = getMonthlyCredit().getProperlyFormattedMonths() +
                getMonthlyDebit().getProperlyFormattedMonths() +
                getMonthlyTax().getProperlyFormattedMonths()
        allList.forEach { linkedSet.add(it.first) }

        return linkedSet.toList()
    }


}
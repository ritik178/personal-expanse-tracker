package net.javaguides.expansetrackerapp.repository;

import net.javaguides.expansetrackerapp.entity.Expanse;
import net.javaguides.expansetrackerapp.entity.MonthlyExpenseSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ExpanseRepository extends JpaRepository<Expanse, Long> {

    @Query("SELECT SUM(e.amount) FROM Expanse e")
    BigDecimal getTotalExpanseFromDB();

    @Query(value = "SELECT DATE_FORMAT(MIN(e.expanse_date), '%M') AS month, " +
            "YEAR(e.expanse_date) AS year, " +
            "SUM(e.amount) AS totalAmount " +
            "FROM expanse e " +
            "GROUP BY YEAR(e.expanse_date), MONTH(e.expanse_date) " +
            "ORDER BY YEAR(e.expanse_date), MONTH(e.expanse_date)", nativeQuery = true)
    List<Object[]> getMonthlyExpenseSummaryRaw();

    @Query("SELECT e.category.name as category, SUM(e.amount) as totalAmount FROM Expanse e GROUP BY e.category.name")
    List<Map<String, Object>> findCategorySummary();

}

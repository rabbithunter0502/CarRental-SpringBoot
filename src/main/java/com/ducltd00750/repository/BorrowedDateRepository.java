package com.ducltd00750.repository;

import com.ducltd00750.entity.AvailableCarsResult;
import com.ducltd00750.entity.BorrowedDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Calendar;
import java.util.List;

@Repository
public interface BorrowedDateRepository extends JpaRepository<BorrowedDate, Long> {
    BorrowedDate findByCustomerId(Long id);
    BorrowedDate findByCarId(Long id);
    List<BorrowedDate> findAll();

    @Query("select NEW com.ducltd00750.entity.AvailableCarsResult "+
            "(b.id, b.car.id, b.car.name, b.car.description, b.car.price) "+
            "from BorrowedDate as b "+
            "where :startDate not between b.startDate and b.endDate "+
            "and :endDate not between b.startDate and b.endDate "+
            "and b.car.id NOT IN (select DISTINCT bd.car.id "+
                "from BorrowedDate bd "+
                "where :startDate between bd.startDate and bd.endDate "+
                "OR :endDate between bd.startDate and bd.endDate) " +
                "group by b.car.id")
    List<AvailableCarsResult> checkAvailableCars(@Param("startDate") Calendar startDate,
                                                 @Param("endDate") Calendar endDate);

    @Query("select NEW com.ducltd00750.entity.AvailableCarsResult "+
            "(b.id, b.car.id, b.car.name, b.car.description, b.car.price) "+
            "from BorrowedDate as b "+
            "where :startDate not between b.startDate and b.endDate "+
            "and :endDate not between b.startDate and b.endDate "+
            "and b.car.id = :carId "+
            "and b.car.id NOT IN (select DISTINCT bd.car.id "+
                "from BorrowedDate bd "+
                "where :startDate between bd.startDate and bd.endDate "+
                "OR :endDate between bd.startDate and bd.endDate)")
    List<AvailableCarsResult> checkAvailableCarById(@Param("startDate") Calendar startDate,
                                                    @Param("endDate") Calendar endDate,
                                                    @Param("carId") Long id);


}

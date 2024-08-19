
package com.example.studentdashboard.querymachine;

import com.example.studentdashboard.cgpadataplot.MonthCount;
import java.sql.SQLException;

public class QueryMachine {
    private String query = "";

    public String queryMachine() throws SQLException {
        MonthCount count = new MonthCount();
        boolean bmrow = count.isBmrow();
        boolean jmrow = count.isJmrow();
        boolean amrow = count.isAmrow();
        boolean smrow = count.isSmrow();
        boolean vmrow = count.isVmrow();
        boolean asmrow = count.isAsmrow();
        boolean kmrow = count.isKmrow();
        boolean mmrow = count.isMmrow();
        boolean pmrow = count.isPmrow();
        boolean mamrow = count.isMamrow();
        boolean fmrow = count.isFmrow();
        boolean cmrow = count.isCmrow();

        if (bmrow && jmrow && amrow && smrow && vmrow && asmrow && kmrow && mmrow && pmrow && mamrow && fmrow && cmrow) {
            query = "SELECT sd.rn, sd.stuName, bm.cgpa, jm.cgpa, am.cgpa, sm.cgpa, bm1.cgpa, am1.cgpa, km.cgpa, mm1.cgpa, pm.cgpa, mm.cgpa, fm.cgpa, cm.cgpa" +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON ( am1.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.kartik_marks km ON ( km.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.mangsir_marks mm1 ON ( mm1.rn = sd.rn  )" +
                    "INNER JOIN dev_scl_test2.push_marks pm ON ( pm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.magh_marks mm ON ( mm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.fagun_marks fm ON ( fm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.chait_marks cm ON ( cm.rn = sd.rn  ) " +
                    "WHERE sd.rn = ?  ";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow && asmrow && kmrow && mmrow && pmrow && mamrow && fmrow) {
            query = "SELECT sd.rn, bm.cgpa, jm.cgpa, am.cgpa, sm.cgpa, bm1.cgpa, am1.cgpa, km.cgpa, mm1.cgpa, pm.cgpa, mm.cgpa, fm.cgpa" +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON ( am1.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.kartik_marks km ON ( km.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.mangsir_marks mm1 ON ( mm1.rn = sd.rn  )" +
                    "INNER JOIN dev_scl_test2.push_marks pm ON ( pm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.magh_marks mm ON ( mm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.fagun_marks fm ON ( fm.rn = sd.rn  ) " +
                    "WHERE sd.rn = ?  ";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow && asmrow && kmrow && mmrow && pmrow && mamrow) {
            query = "SELECT sd.rn, bm.cgpa, jm.cgpa, am.cgpa, sm.cgpa, bm1.cgpa, am1.cgpa, km.cgpa, mm1.cgpa, pm.cgpa, mm.cgpa" +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON ( am1.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.kartik_marks km ON ( km.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.mangsir_marks mm1 ON ( mm1.rn = sd.rn  )" +
                    "INNER JOIN dev_scl_test2.push_marks pm ON ( pm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.magh_marks mm ON ( mm.rn = sd.rn  ) " +
                    "WHERE sd.rn = ?  ";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow && asmrow && kmrow && mmrow && pmrow) {
            query = "SELECT sd.rn, bm.cgpa, jm.cgpa, am.cgpa, sm.cgpa, bm1.cgpa, am1.cgpa, km.cgpa, mm1.cgpa, pm.cgpa" +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON ( am1.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.kartik_marks km ON ( km.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.mangsir_marks mm1 ON ( mm1.rn = sd.rn  )" +
                    "INNER JOIN dev_scl_test2.push_marks pm ON ( pm.rn = sd.rn  ) " +
                    "WHERE sd.rn = ?  ";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow && asmrow && kmrow && mmrow) {
            query = "SELECT sd.rn, bm.cgpa, jm.cgpa, am.cgpa, sm.cgpa, bm1.cgpa, am1.cgpa, km.cgpa, mm1.cgpa" +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON ( am1.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.kartik_marks km ON ( km.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.mangsir_marks mm1 ON ( mm1.rn = sd.rn  )" +
                    "WHERE sd.rn = ?  ";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow && asmrow && kmrow) {
            query = "SELECT sd.rn, bm.cgpa, jm.cgpa, am.cgpa, sm.cgpa, bm1.cgpa, am1.cgpa, km.cgpa" +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON ( am1.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.kartik_marks km ON ( km.rn = sd.rn  ) " +
                    "WHERE sd.rn = ?  ";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow && asmrow) {
            query = "SELECT sd.rn, bm.cgpa, jm.cgpa, am.cgpa, sm.cgpa, bm1.cgpa, am1.cgpa " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON bm.rn = sd.rn " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON jm.rn = sd.rn " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON am.rn = sd.rn " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON sm.rn = sd.rn " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON bm1.rn = sd.rn " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON am1.rn = sd.rn " +
                    "WHERE sd.rn = ?";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow) {
            query = "SELECT sd.rn, bm.cgpa, jm.cgpa, am.cgpa, sm.cgpa, bm1.cgpa" +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  ) " +
                    "WHERE sd.rn = ?  ";
        }
        else if (bmrow && jmrow && amrow && smrow) {
            query = "SELECT sd.rn, bm.cgpa, jm.cgpa, am.cgpa, sm.cgpa " +
                    "FROM dev_scl_test2.student_detail sd  " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  ) " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  ) " +
                    "WHERE sd.rn = ?";
        }
        else if (bmrow && jmrow && amrow) {
            query = "SELECT sd.rn, bm.cgpa, jm.cgpa, am.cgpa " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON bm.rn = sd.rn " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON jm.rn = sd.rn " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON am.rn = sd.rn " +
                    "WHERE sd.rn = ?";
        }
        else if (bmrow && jmrow) {
            query = "SELECT sd.rn, bm.cgpa, jm.cgpa " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON bm.rn = sd.rn " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON jm.rn = sd.rn " +
                    "WHERE sd.rn = ?";
        }
        else if(bmrow) {
            query = "SELECT sd.rn, bm.cgpa " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON bm.rn = sd.rn " +
                    "WHERE sd.rn = ?";
        }
        else{
            System.out.println("No query Selected");
//            showMessageAndFadeAway("No exams has been conducted yet");
        }
        return query;
    }

    public String academicProfileQueryMachine() throws SQLException{
        MonthCount count = new MonthCount();
        boolean bmrow = count.isBmrow();
        boolean jmrow = count.isJmrow();
        boolean amrow = count.isAmrow();
        boolean smrow = count.isSmrow();
        boolean vmrow = count.isVmrow();
        boolean asmrow = count.isAsmrow();
        boolean kmrow = count.isKmrow();
        boolean mmrow = count.isMmrow();
        boolean pmrow = count.isPmrow();
        boolean mamrow = count.isMamrow();
        boolean fmrow = count.isFmrow();
        boolean cmrow = count.isCmrow();
        System.out.println(cmrow);

        if (bmrow && jmrow && amrow && smrow && vmrow && asmrow && kmrow && mmrow && pmrow && mamrow && fmrow && cmrow) {
            query = "SELECT sd.rn, sd.student_name, " +
                    "bm.english, bm.nepali, bm.math, bm.science, bm.social, bm.opt_i, bm.opt_ii, bm.cgpa, " +
                    "jm.english, jm.nepali, jm.math, jm.science, jm.social, jm.opt_i, jm.opt_ii, jm.cgpa, " +
                    "am.english, am.nepali, am.math, am.science, am.social, am.opt_i, am.opt_ii, am.cgpa, " +
                    "sm.english, sm.nepali, sm.math, sm.science, sm.social, sm.opt_i, sm.opt_ii, sm.cgpa, " +
                    "bm1.english, bm1.nepali, bm1.math, bm1.science, bm1.social, bm1.opt_i, bm1.opt_ii, bm1.cgpa, " +
                    "am1.english, am1.nepali, am1.math, am1.science, am1.social, am1.opt_i, am1.opt_ii, am1.cgpa, " +
                    "km.english, km.nepali, km.math, km.science, km.social, km.opt_i, km.opt_ii, km.cgpa, " +
                    "mm.english, mm.nepali, mm.math, mm.science, mm.social, mm.opt_i, mm.opt_ii, mm.cgpa, " +
                    "pm.english, pm.nepali, pm.math, pm.science, pm.social, pm.opt_i, pm.opt_ii, pm.cgpa, " +
                    "mm1.english, mm1.nepali, mm1.math, mm1.science, mm1.social, mm1.opt_i, mm1.opt_ii, mm1.cgpa, " +
                    "fm.english, fm.nepali, fm.math, fm.science, fm.social, fm.opt_i, fm.opt_ii, fm.cgpa, " +
                    "cm.english, cm.nepali, cm.math, cm.science, cm.social, cm.opt_i, cm.opt_ii, cm.cgpa, " +
                    "m.month_id, m.month_name " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON ( am1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.kartik_marks km ON ( km.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.mangsir_marks mm ON ( mm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.push_marks pm ON ( pm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.magh_marks mm1 ON ( mm1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.fagun_marks fm ON ( fm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.chait_marks cm ON ( cm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.month m ON ( m.month_id = bm.month_id  )   "+
                    "WHERE sd.rn = ? ";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow && asmrow && kmrow && mmrow && pmrow && mamrow && fmrow) {
            query = "SELECT sd.rn, sd.student_name, " +
                    "bm.english, bm.nepali, bm.math, bm.science, bm.social, bm.opt_i, bm.opt_ii, bm.cgpa, " +
                    "jm.english, jm.nepali, jm.math, jm.science, jm.social, jm.opt_i, jm.opt_ii, jm.cgpa, " +
                    "am.english, am.nepali, am.math, am.science, am.social, am.opt_i, am.opt_ii, am.cgpa, " +
                    "sm.english, sm.nepali, sm.math, sm.science, sm.social, sm.opt_i, sm.opt_ii, sm.cgpa, " +
                    "bm1.english, bm1.nepali, bm1.math, bm1.science, bm1.social, bm1.opt_i, bm1.opt_ii, bm1.cgpa, " +
                    "am1.english, am1.nepali, am1.math, am1.science, am1.social, am1.opt_i, am1.opt_ii, am1.cgpa, " +
                    "km.english, km.nepali, km.math, km.science, km.social, km.opt_i, km.opt_ii, km.cgpa, " +
                    "mm.english, mm.nepali, mm.math, mm.science, mm.social, mm.opt_i, mm.opt_ii, mm.cgpa, " +
                    "pm.english, pm.nepali, pm.math, pm.science, pm.social, pm.opt_i, pm.opt_ii, pm.cgpa, " +
                    "mm1.english, mm1.nepali, mm1.math, mm1.science, mm1.social, mm1.opt_i, mm1.opt_ii, mm1.cgpa, " +
                    "fm.english, fm.nepali, fm.math, fm.science, fm.social, fm.opt_i, fm.opt_ii, fm.cgpa, " +
                    "m.month_id, m.month_name " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON ( am1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.kartik_marks km ON ( km.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.mangsir_marks mm ON ( mm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.push_marks pm ON ( pm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.magh_marks mm1 ON ( mm1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.fagun_marks fm ON ( fm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.month m ON ( m.month_id = bm.month_id  )   "+
                    "WHERE sd.rn = ? ";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow && asmrow && kmrow && mmrow && pmrow && mamrow) {
            query = "SELECT sd.rn, sd.student_name, " +
                    "bm.english, bm.nepali, bm.math, bm.science, bm.social, bm.opt_i, bm.opt_ii, bm.cgpa, " +
                    "jm.english, jm.nepali, jm.math, jm.science, jm.social, jm.opt_i, jm.opt_ii, jm.cgpa, " +
                    "am.english, am.nepali, am.math, am.science, am.social, am.opt_i, am.opt_ii, am.cgpa, " +
                    "sm.english, sm.nepali, sm.math, sm.science, sm.social, sm.opt_i, sm.opt_ii, sm.cgpa, " +
                    "bm1.english, bm1.nepali, bm1.math, bm1.science, bm1.social, bm1.opt_i, bm1.opt_ii, bm1.cgpa, " +
                    "am1.english, am1.nepali, am1.math, am1.science, am1.social, am1.opt_i, am1.opt_ii, am1.cgpa, " +
                    "km.english, km.nepali, km.math, km.science, km.social, km.opt_i, km.opt_ii, km.cgpa, " +
                    "mm.english, mm.nepali, mm.math, mm.science, mm.social, mm.opt_i, mm.opt_ii, mm.cgpa, " +
                    "pm.english, pm.nepali, pm.math, pm.science, pm.social, pm.opt_i, pm.opt_ii, pm.cgpa, " +
                    "mm1.english, mm1.nepali, mm1.math, mm1.science, mm1.social, mm1.opt_i, mm1.opt_ii, mm1.cgpa, " +
                    "m.month_id, m.month_name " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON ( am1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.kartik_marks km ON ( km.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.mangsir_marks mm ON ( mm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.push_marks pm ON ( pm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.magh_marks mm1 ON ( mm1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.month m ON ( m.month_id = bm.month_id  )   "+
                    "WHERE sd.rn = ? ";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow && asmrow && kmrow && mmrow && pmrow) {
            query = "SELECT sd.rn, sd.student_name, " +
                    "bm.english, bm.nepali, bm.math, bm.science, bm.social, bm.opt_i, bm.opt_ii, bm.cgpa, " +
                    "jm.english, jm.nepali, jm.math, jm.science, jm.social, jm.opt_i, jm.opt_ii, jm.cgpa, " +
                    "am.english, am.nepali, am.math, am.science, am.social, am.opt_i, am.opt_ii, am.cgpa, " +
                    "sm.english, sm.nepali, sm.math, sm.science, sm.social, sm.opt_i, sm.opt_ii, sm.cgpa, " +
                    "bm1.english, bm1.nepali, bm1.math, bm1.science, bm1.social, bm1.opt_i, bm1.opt_ii, bm1.cgpa, " +
                    "am1.english, am1.nepali, am1.math, am1.science, am1.social, am1.opt_i, am1.opt_ii, am1.cgpa, " +
                    "km.english, km.nepali, km.math, km.science, km.social, km.opt_i, km.opt_ii, km.cgpa, " +
                    "mm.english, mm.nepali, mm.math, mm.science, mm.social, mm.opt_i, mm.opt_ii, mm.cgpa, " +
                    "pm.english, pm.nepali, pm.math, pm.science, pm.social, pm.opt_i, pm.opt_ii, pm.cgpa, " +
                    "m.month_id, m.month_name " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON ( am1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.kartik_marks km ON ( km.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.mangsir_marks mm ON ( mm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.push_marks pm ON ( pm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.month m ON ( m.month_id = bm.month_id  )   "+
                    "WHERE sd.rn = ? ";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow && asmrow && kmrow && mmrow) {
            query = "SELECT sd.rn, sd.student_name, " +
                    "bm.english, bm.nepali, bm.math, bm.science, bm.social, bm.opt_i, bm.opt_ii, bm.cgpa, " +
                    "jm.english, jm.nepali, jm.math, jm.science, jm.social, jm.opt_i, jm.opt_ii, jm.cgpa, " +
                    "am.english, am.nepali, am.math, am.science, am.social, am.opt_i, am.opt_ii, am.cgpa, " +
                    "sm.english, sm.nepali, sm.math, sm.science, sm.social, sm.opt_i, sm.opt_ii, sm.cgpa, " +
                    "bm1.english, bm1.nepali, bm1.math, bm1.science, bm1.social, bm1.opt_i, bm1.opt_ii, bm1.cgpa, " +
                    "am1.english, am1.nepali, am1.math, am1.science, am1.social, am1.opt_i, am1.opt_ii, am1.cgpa, " +
                    "km.english, km.nepali, km.math, km.science, km.social, km.opt_i, km.opt_ii, km.cgpa, " +
                    "mm.english, mm.nepali, mm.math, mm.science, mm.social, mm.opt_i, mm.opt_ii, mm.cgpa, " +
                    "m.month_id, m.month_name " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON ( am1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.kartik_marks km ON ( km.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.mangsir_marks mm ON ( mm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.month m ON ( m.month_id = bm.month_id  )   "+
                    "WHERE sd.rn = ? ";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow && asmrow && kmrow) {
            query = "SELECT sd.rn, sd.student_name, " +
                    "bm.english, bm.nepali, bm.math, bm.science, bm.social, bm.opt_i, bm.opt_ii, bm.cgpa, " +
                    "jm.english, jm.nepali, jm.math, jm.science, jm.social, jm.opt_i, jm.opt_ii, jm.cgpa, " +
                    "am.english, am.nepali, am.math, am.science, am.social, am.opt_i, am.opt_ii, am.cgpa, " +
                    "sm.english, sm.nepali, sm.math, sm.science, sm.social, sm.opt_i, sm.opt_ii, sm.cgpa, " +
                    "bm1.english, bm1.nepali, bm1.math, bm1.science, bm1.social, bm1.opt_i, bm1.opt_ii, bm1.cgpa, " +
                    "am1.english, am1.nepali, am1.math, am1.science, am1.social, am1.opt_i, am1.opt_ii, am1.cgpa, " +
                    "km.english, km.nepali, km.math, km.science, km.social, km.opt_i, km.opt_ii, km.cgpa, " +
                    "m.month_id, m.month_name " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON ( am1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.kartik_marks km ON ( km.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.month m ON ( m.month_id = bm.month_id  )   "+
                    "WHERE sd.rn = ? ";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow && asmrow) {
            query = "SELECT sd.rn, sd.student_name, " +
                    "bm.english, bm.nepali, bm.math, bm.science, bm.social, bm.opt_i, bm.opt_ii, bm.cgpa, " +
                    "jm.english, jm.nepali, jm.math, jm.science, jm.social, jm.opt_i, jm.opt_ii, jm.cgpa, " +
                    "am.english, am.nepali, am.math, am.science, am.social, am.opt_i, am.opt_ii, am.cgpa, " +
                    "sm.english, sm.nepali, sm.math, sm.science, sm.social, sm.opt_i, sm.opt_ii, sm.cgpa, " +
                    "bm1.english, bm1.nepali, bm1.math, bm1.science, bm1.social, bm1.opt_i, bm1.opt_ii, bm1.cgpa, " +
                    "am1.english, am1.nepali, am1.math, am1.science, am1.social, am1.opt_i, am1.opt_ii, am1.cgpa, " +
                    "m.month_id, m.month_name " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asoj_marks am1 ON ( am1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.month m ON ( m.month_id = bm.month_id  )   "+
                    "WHERE sd.rn = ? ";
        }
        else if (bmrow && jmrow && amrow && smrow && vmrow) {
            query = "SELECT sd.rn, sd.student_name, " +
                    "bm.english, bm.nepali, bm.math, bm.science, bm.social, bm.opt_i, bm.opt_ii, bm.cgpa, " +
                    "jm.english, jm.nepali, jm.math, jm.science, jm.social, jm.opt_i, jm.opt_ii, jm.cgpa, " +
                    "am.english, am.nepali, am.math, am.science, am.social, am.opt_i, am.opt_ii, am.cgpa, " +
                    "sm.english, sm.nepali, sm.math, sm.science, sm.social, sm.opt_i, sm.opt_ii, sm.cgpa, " +
                    "bm1.english, bm1.nepali, bm1.math, bm1.science, bm1.social, bm1.opt_i, bm1.opt_ii, bm1.cgpa, " +
                    "m.month_id, m.month_name " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.bhadau_marks bm1 ON ( bm1.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.month m ON ( m.month_id = bm.month_id  )   "+
                    "WHERE sd.rn = ? ";
        }
        else if (bmrow && jmrow && amrow && smrow) {
            query =  "SELECT sd.rn, sd.student_name, " +
                    "bm.english, bm.nepali, bm.math, bm.science, bm.social, bm.opt_i, bm.opt_ii, bm.cgpa, " +
                    "jm.english, jm.nepali, jm.math, jm.science, jm.social, jm.opt_i, jm.opt_ii, jm.cgpa, " +
                    "am.english, am.nepali, am.math, am.science, am.social, am.opt_i, am.opt_ii, am.cgpa, " +
                    "sm.english, sm.nepali, sm.math, sm.science, sm.social, sm.opt_i, sm.opt_ii, sm.cgpa, " +
                    "m.month_id, m.month_name " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.saun_marks sm ON ( sm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.month m ON ( m.month_id = bm.month_id  )   "+
                    "WHERE sd.rn = ? ";
        }
        else if (bmrow && jmrow && amrow) {
            query = "SELECT sd.rn, sd.student_name, " +
                    "bm.english, bm.nepali, bm.math, bm.science, bm.social, bm.opt_i, bm.opt_ii, bm.cgpa, " +
                    "jm.english, jm.nepali, jm.math, jm.science, jm.social, jm.opt_i, jm.opt_ii, jm.cgpa, " +
                    "am.english, am.nepali, am.math, am.science, am.social, am.opt_i, am.opt_ii, am.cgpa, " +
                    "m.month_id, m.month_name " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.asar_marks am ON ( am.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.month m ON ( m.month_id = bm.month_id  )   "+
                    "WHERE sd.rn = ? ";
        }
        else if (bmrow && jmrow) {
            query = "SELECT sd.rn, sd.student_name, " +
                    "bm.english, bm.nepali, bm.math, bm.science, bm.social, bm.opt_i, bm.opt_ii, bm.cgpa, " +
                    "jm.english, jm.nepali, jm.math, jm.science, jm.social, jm.opt_i, jm.opt_ii, jm.cgpa, " +
                    "m.month_name " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.jeth_marks jm ON ( jm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.month m ON ( m.month_id = bm.month_id  )   "+
                    "WHERE sd.rn = ? ";
        }
        else if(bmrow) {
            query = "SELECT sd.rn, sd.student_name, " +
                    "bm.english, bm.nepali, bm.math, bm.science, bm.social, bm.opt_i, bm.opt_ii, bm.cgpa, " +
                    "m.month_name " +
                    "FROM dev_scl_test2.student_detail sd " +
                    "INNER JOIN dev_scl_test2.baisakh_marks bm ON ( bm.rn = sd.rn  )  " +
                    "INNER JOIN dev_scl_test2.month m ON ( m.month_id = bm.month_id  )   "+
                    "WHERE sd.rn = ? ";
        }
        else{
            query = "SELECT sd.rn, sd.student_name, " +
                    "WHERE sd.rn = ? ";
        }
        return query;
    }
}

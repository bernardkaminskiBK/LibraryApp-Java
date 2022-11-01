package infrastructure.data.repositories;

import core.abstractions.repositories.IDvdRepository;
import core.entities.Dvd;
import core.enums.eTitleType;
import infrastructure.data.DatabaseContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DvdRepository implements IDvdRepository {

    @Override
    public ArrayList<Dvd> getAll() {
        String selectStmt = "SELECT * FROM librarydb.dvd";

        try {
            ResultSet rsDvds = DatabaseContext.dbExecuteQuery(selectStmt);
            return getAllDvd(rsDvds);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    private ArrayList<Dvd> getAllDvd(ResultSet rs) throws SQLException {
        ArrayList<Dvd> dvds = new ArrayList<>();

        while (rs.next()) {
            Dvd dvd = new Dvd();
            getTitleFromResultSet(rs, dvd);
            dvds.add(dvd);
        }

        return dvds;
    }

    @Override
    public Dvd create(Dvd entity) {
        String insertDvdStmt = "" +
                "INSERT INTO librarydb.dvd " +
                "(Author, Name, AvailableCopies, NumberOfChapters, NumberOfMinutes) " +
                "VALUES (" +
                "'" + entity.getAuthor() + "'" + ", " +
                "'" + entity.getName() + "'" + ", " +
                entity.getAvailableCopies() + ", " +
                entity.getNumberOfChapters() + ", " +
                entity.getNumberOfMinutes() + ")";

        try {
            DatabaseContext.dbExecuteUpdate(insertDvdStmt);
            addDvdIntoTitleTable(entity);
            return entity;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void addDvdIntoTitleTable(Dvd entity) {
        String insertStmt = "INSERT INTO \n" +
                "`librarydb`.`title` (`Name`, `Author`, `AvailableCopies`, `Discriminator`, `NumberOfPages`, `ISBN`, `NumberOfChapters`, `NumberOfMinutes`, `TotalAvailableCopies`) \n" +
                "VALUES " +
                "(" +
                "'" + entity.getName() + "', " +
                "'" + entity.getAuthor() + "', " +
                entity.getAvailableCopies() + ", " +
                "'" + eTitleType.dvd + "', " +
                null + ", " +
                null + ", " +
                entity.getNumberOfChapters() + ", " +
                entity.getNumberOfMinutes() + ", " +
                entity.getAvailableCopies() + ");";

        try {
            DatabaseContext.dbExecuteUpdate(insertStmt);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dvd delete(int id) {
        String deleteStmt = "DELETE FROM librarydb.dvd WHERE id = " + id;

        var entityDvd = this.getById(id);
        if (entityDvd == null) {
            return null;
        }

        try {
            DatabaseContext.dbExecuteUpdate(deleteStmt);
            return entityDvd;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Dvd getById(int id) {
        String selectStmt = "SELECT * FROM librarydb.dvd WHERE Id = " + id;

        try {
            ResultSet rsEmp = DatabaseContext.dbExecuteQuery(selectStmt);
            return getDvdFromResultSet(rsEmp);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(int id, Dvd entity) {
        String updateStmt =
                "UPDATE librarydb.dvd" +
                        " SET AvailableCopies = " + entity.getAvailableCopies() +
                        " WHERE Id = " + id + ";";

        try {
            DatabaseContext.dbExecuteUpdate(updateStmt);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Dvd getDvdFromResultSet(ResultSet rsDvd) throws SQLException {
        Dvd dvd = null;
        if (rsDvd.next()) {
            dvd = new Dvd();
            getTitleFromResultSet(rsDvd, dvd);
        }
        return dvd;
    }

    private void getTitleFromResultSet(ResultSet rsDvd, Dvd dvd) throws SQLException {
        dvd.setId(rsDvd.getInt("Id"));
        dvd.setAuthor(rsDvd.getString("Author"));
        dvd.setName(rsDvd.getString("Name"));
        dvd.setAvailableCopies(rsDvd.getInt("AvailableCopies"));
        dvd.setNumberOfChapters(rsDvd.getInt("NumberOfChapters"));
        dvd.setNumberOfMinutes(rsDvd.getInt("NumberOfMinutes"));
    }

    @Override
    public boolean isDvdAvailable(int id) {
        return getById(id).getAvailableCopies() > 0;
    }
}

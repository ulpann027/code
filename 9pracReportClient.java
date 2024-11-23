public class ReportClient {
    public static void main(String[] args) {
        IReport report = new SalesReport();
        report = new DateFilterDecorator(report);
        report = new CsvExportDecorator(report);

        System.out.println(report.generate());
    }
}

interface IReport {
    String generate();
}

class SalesReport implements IReport {
    @Override
    public String generate() {
        return "Sales Report Data";
    }
}

class UserReport implements IReport {
    @Override
    public String generate() {
        return "User Report Data";
    }
}

abstract class ReportDecorator implements IReport {
    protected IReport report;

    public ReportDecorator(IReport report) {
        this.report = report;
    }
}

class DateFilterDecorator extends ReportDecorator {
    public DateFilterDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        return report.generate() + " | Filtered by Date";
    }
}

class SortingDecorator extends ReportDecorator {
    public SortingDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        return report.generate() + " | Sorted Data";
    }
}

class CsvExportDecorator extends ReportDecorator {
    public CsvExportDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        return report.generate() + " | Exported to CSV";
    }
}

class PdfExportDecorator extends ReportDecorator {
    public PdfExportDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        return report.generate() + " | Exported to PDF";
    }
}

package sysc4806.pm4y.models;

public enum EngineeringStream {
    AEROSPACE,
    ARCHITECTURE,
    BIOMED_ELEC,
    BIOMED_MECH,
    CIVIL,
    COMMUNICATIONS,
    COMPUTER_SYSTEMS,
    ELECTRICAL,
    ENG_PHYSICS,
    ENVIRONMENTAL,
    MECHANICAL,
    SOFTWARE,
    SUSTAINABLE_RENEWABLE;

    public String getStreamName() {
        switch (this) {
            case AEROSPACE:
                return "Aerospace Engineering";
            case CIVIL:
                return "Civil Engineering";
            case SOFTWARE:
                return "Software Engineering";
            case ELECTRICAL:
                return "Electrical Engineering";
            case MECHANICAL:
                return "Mechanical Engineering";
            case BIOMED_ELEC:
                return "Biomedical & Electrical Engineering";
            case BIOMED_MECH:
                return "Biomedical & Mechanical Engineering";
            case ENG_PHYSICS:
                return "Engineering Physics";
            case ARCHITECTURE:
                return "Architectural Engineering";
            case ENVIRONMENTAL:
                return "Environmental Engineering";
            case COMMUNICATIONS:
                return "Communications Engineering";
            case COMPUTER_SYSTEMS:
                return "Computer Systems Engineering";
            case SUSTAINABLE_RENEWABLE:
                return "Sustainable & Renewable Engineering";
            default:
                return "ERROR: NOT A VALID ENGINEERING STREAM";
        }
    }

}

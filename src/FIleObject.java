public class FIleObject {
    private Integer value;
    private Integer valueFrom;
    private Integer valueTo;

    public FIleObject(Integer value, Integer valueFrom, Integer valueTo) {
        this.value = value;
        this.valueFrom = valueFrom;
        this.valueTo = valueTo;
    }

    public Integer getValue() {
        return this.value;
    }

    public Integer getValueFrom() {
        return this.valueFrom;
    }

    public Integer getValueTo() {
        return this.valueTo;
    }
}

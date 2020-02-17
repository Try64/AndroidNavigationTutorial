package com.try64.navigationtutorial;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class Money implements Parcelable {

    public static final Creator<Money> CREATOR = new Creator<Money>() {
        @Override
        public Money createFromParcel(Parcel in) {
            return new Money(in);
        }

        @Override
        public Money[] newArray(int size) {
            return new Money[size];
        }
    };
    private BigDecimal value;

    /**
     * This is the only constructor getting the ammount
     *
     * @param money is the {@link BigDecimal} value to
     *              fulfill the value
     */
    public Money(BigDecimal money) {
        this.value = money;
    }

    protected Money(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Getter
     *
     * @return {@link BigDecimal} value
     */
    public BigDecimal getValue() {
        return this.value;
    }

    /**
     * Setter
     *
     * @param money is the {@link BigDecimal} value to
     *              *              fulfill the value
     */
    public void setValue(BigDecimal money) {
        this.value = money;
    }

}

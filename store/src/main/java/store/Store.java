package store;

// Please don't modify the class name.
public class Store {
    Item[] items;

    // Please don't modify the signature of this method.
    public Store(Item[] items) {
        this.items = items;
    }

    // Please don't modify the signature of this method.
    public void updateValue() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Wine")
                    && !items[i].name.equals("Show Ticket")) {
                if (items[i].value > 0) {
                    if (!items[i].name.equals("Sulfuras")) {
                        items[i].value = items[i].value - 1;
                    }
                }
            } else {
                if (items[i].value < 50) {
                    items[i].value = items[i].value + 1;

                    if (items[i].name.equals("Show Ticket")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].value < 50) {
                                items[i].value = items[i].value + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].value < 50) {
                                items[i].value = items[i].value + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Wine")) {
                    if (!items[i].name.equals("Show Ticket")) {
                        if (items[i].value > 0) {
                            items[i].value = items[i].value - 1;
                        }
                    } else {
                        items[i].value = items[i].value - items[i].value;
                    }
                } else {
                    items[i].value = items[i].value + 1;
                }
            }
        }
    }
}

CREATE TABLE indent (
                        id UUID PRIMARY KEY,
                        indent_number VARCHAR(50) NOT NULL UNIQUE,
                        hospital_id VARCHAR(100) NOT NULL,
                        status VARCHAR(50) NOT NULL,
                        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE indent_items (
                              id UUID PRIMARY KEY,
                              item_name VARCHAR(255) NOT NULL,
                              quantity INTEGER NOT NULL CHECK (quantity > 0),
                              indent_id UUID NOT NULL,

                              CONSTRAINT fk_indent
                                  FOREIGN KEY (indent_id)
                                      REFERENCES indent(id)
                                      ON DELETE CASCADE
);
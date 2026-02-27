-- Rename itemName to drugName
ALTER TABLE indent_items RENAME COLUMN item_name TO drug_name;

-- Add drugCode column
ALTER TABLE indent_items ADD COLUMN drug_code VARCHAR(100);
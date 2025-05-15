export interface Libro {
  data: Data;
}

export interface Data {
  id: number;
  Year: number;
  Title: string;
  villains: Villain[];
}

export interface Villain {
  name: string;
  url: string;
}

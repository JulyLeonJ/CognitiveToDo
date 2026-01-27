export interface Task {
  id?: string; 
  title: string;
  mandatory: boolean;
  duedate: Date;
  state: number;
  description: string;
}

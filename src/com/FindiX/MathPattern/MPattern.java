package com.FindiX.MathPattern;

public class MPattern {
	private final String abs = "abs";
	private final String sin = "sin";
	private final String cos = "cos";
	private final String tan = "tan";
	private final char root = '��';
	private final String pow = "^";
	// private final String arcsin = "arcsin";
	// private final String arccos = "arccos";
	// private final String arctan = "arctan";
	private final char PI = '��';
	private final char E = 'e';
	private final char SIGN[] = { '*', '/', '%', '+', '-' };
	private boolean mode = true;

	// ��������ĺ�������
	public MPattern() {
	}// ���캯��

	public MPattern(String Pattern) {// �������Ĺ��캯��
		this.OPattern = new StringBuffer(Pattern);
	}

	public void setPattern(String Pattern) {
		this.OPattern = new StringBuffer(Pattern);
	}

	public double solvePattern(boolean mode) {// ������ʾ��/���� trueΪ���� falseΪ�Ƕ�
		double result = 0;
		this.mode = mode;
		fillParenthese();
		signTone();
		smartTip();
		if (hasPow(OPattern))
			solvePow(OPattern);
		result = solveComplex(OPattern);
		// result = solveSimple(OPattern);
		return result;
	}

	private boolean hasParenthese(StringBuffer Pattern) {// �жϱ��ʽ���Ƿ�������
		for (int i = 0; i < Pattern.length(); i++) {
			if (Pattern.charAt(i) == '(' || Pattern.charAt(i) == '��')
				return true;
		}
		return false;
	}

	private boolean hasFunction(StringBuffer Pattern) {// �жϱ��ʽ���Ƿ�����ѧ����
		if (Pattern.indexOf(sin) != -1)
			return true;
		else if (Pattern.indexOf(cos) != -1)
			return true;
		else if (Pattern.indexOf(tan) != -1)
			return true;
		else if (Pattern.indexOf(abs) != -1)
			return true;
		else
			return false;
	}

	private boolean hasPow(StringBuffer Pattern) {// �жϱ��ʽ���Ƿ���ָ��
		if (Pattern.indexOf(pow) != -1)
			return true;
		else
			return false;
	}

	private boolean hasPow(String Pattern) {// �жϱ��ʽ���Ƿ���ָ��
		if (Pattern.indexOf(pow) != -1)
			return true;
		else
			return false;
	}

	private void signTone() {
		/*
		 * while (OPattern.indexOf("%") != -1) { for (int i = 0; i <
		 * OPattern.length(); i++) { if (OPattern.charAt(i) == '%') { int start
		 * = i; for (int j = i - 1; j >= 0; j--) { if
		 * (Character.isDigit(OPattern.charAt(j))) start--; } OPattern.replace(
		 * start, i + 1, (Double.valueOf(OPattern.substring(start, i)) / 100) +
		 * ""); break; } } }
		 */
		for (int i = 0; i < OPattern.length(); i++) {
			if (OPattern.charAt(i) == '��') {
				OPattern.replace(i, i + 1, "*");
			} else if (OPattern.charAt(i) == '��') {
				OPattern.replace(i, i + 1, "/");
			}
		}
	}

	private void smartTip() {
		while (OPattern.indexOf("%") != -1) {
			for (int i = 0; i < OPattern.length(); i++) {
				if (OPattern.charAt(i) == '%') {
					int start = i;
					for (int j = i - 1; j >= 0; j--) {
						if (Character.isDigit(OPattern.charAt(j)))
							start--;
					}
					OPattern.replace(
							start,
							i + 1,
							(Double.valueOf(OPattern.substring(start, i)) / 100)
									+ "");
					break;
				}
			}
		}
		while (OPattern.indexOf(PI + "") != -1
				|| OPattern.indexOf("pi") != -1
				|| OPattern.indexOf("PI") != -1
				|| OPattern.indexOf(E + "") != -1
				|| (OPattern.indexOf(sin) != 0 && OPattern.indexOf(sin) != -1 && Character
						.isDigit(OPattern.charAt(OPattern.indexOf(sin) - 1)))
				|| (OPattern.indexOf(cos) != 0 && OPattern.indexOf(cos) != -1 && Character
						.isDigit(OPattern.charAt(OPattern.indexOf(cos) - 1)))
				|| (OPattern.indexOf(abs) != 0 && OPattern.indexOf(abs) != -1 && Character
						.isDigit(OPattern.charAt(OPattern.indexOf(abs) - 1)))
				|| (OPattern.indexOf(tan) != 0 && OPattern.indexOf(tan) != -1 && Character
						.isDigit(OPattern.charAt(OPattern.indexOf(tan) - 1)))
				|| OPattern.indexOf(root + "") != -1
				|| OPattern.indexOf("mod") != -1) {
			for (int i = 0; i < OPattern.length(); i++) {
				if (OPattern.charAt(i) == PI) {
					if(i==0){
						OPattern.replace(i, i + 1, Math.PI + "");
						break;
					}
					if (Character.isDigit(OPattern.charAt(i - 1))) {
						OPattern.replace(i, i + 1, "*" + Math.PI);
					} else {
						OPattern.replace(i, i + 1, Math.PI + "");
					}
					break;
				} else if ( (OPattern.charAt(i) == 'p' || OPattern.charAt(i) == 'P')
						&& (OPattern.charAt(i + 1) == 'i' || OPattern.charAt(i) == 'I')) {
					if(i==0){
						OPattern.replace(i, i + 2, Math.PI + "");
						break;
					}
					if (Character.isDigit(OPattern.charAt(i - 1))) {
						OPattern.replace(i, i + 2, "*" + Math.PI);
					} else {
						OPattern.replace(i, i + 2, Math.PI + "");
					}
					break;
				} else if (OPattern.charAt(i) == E) {
					if(i==0){
						OPattern.replace(i, i + 1, Math.E + "");
						break;
					}
					if (Character.isDigit(OPattern.charAt(i - 1))) {
						OPattern.replace(i, i + 1, "*" + Math.E);
					} else {
						OPattern.replace(i, i + 1, Math.E + "");
					}
					break;
				} else if (OPattern.charAt(i) == 'm') {
					OPattern.replace(i, i + 3, "%");
					break;
				} else if (OPattern.charAt(i) == root) {
					int end = i + 1;
					for (int j = i + 1; j < OPattern.length(); j++) {
						if (Character.isDigit(OPattern.charAt(j))
								|| OPattern.charAt(j) == '.') {
							end++;
							break;
						}

					}
					OPattern.insert(end, "^0.5");
					OPattern.deleteCharAt(i);
					if (i != 0 && Character.isDigit(OPattern.charAt(i - 1))) {
						OPattern.insert(i, "*");
					}
					break;
				} else if (i != 0 && OPattern.charAt(i) == 's'
						&& OPattern.charAt(i + 1) == 'i') {
					if (Character.isDigit(OPattern.charAt(i - 1))) {
						OPattern.insert(i, "*");
					}
				} else if (i != 0 && OPattern.charAt(i) == 'c'
						&& OPattern.charAt(i + 1) == 'o') {
					if (Character.isDigit(OPattern.charAt(i - 1))) {
						OPattern.insert(i, "*");
					}
				} else if (i != 0 && OPattern.charAt(i) == 't'
						&& OPattern.charAt(i + 1) == 'a') {
					if (Character.isDigit(OPattern.charAt(i - 1))) {
						OPattern.insert(i, "*");
					}
				} else if (i != 0 && OPattern.charAt(i) == 'a'
						&& OPattern.charAt(i + 1) == 'b') {
					if (Character.isDigit(OPattern.charAt(i - 1))) {
						OPattern.insert(i, "*");
					}
				}
			}
		}
	}

	public int fillParenthese() {
		int num = 0;
		if (hasParenthese(OPattern)) {
			for (int i = 0; i < OPattern.length(); i++) {
				if (OPattern.charAt(i) == '(' || OPattern.charAt(i) == '��') {
					num++;
				}
				if (OPattern.charAt(i) == ')' || OPattern.charAt(i) == '��') {
					num--;
				}
			}
		}
		for (int i = 0; i < num; i++) {
			OPattern.insert(OPattern.length(), ")");
		}
		return num;
	}

	/*
	 * private boolean isSimple(String Pattern) {// �����ѧ���ʽ�Ƿ����ڼ򵥵� ���������������� for
	 * (int i = 0; i < Pattern.length(); i++) { if
	 * (Character.isLetter(Pattern.charAt(i))) return false; } return true; }
	 */
	private double solveSimple(StringBuffer Pattern) {// �����������ı��ʽ
		double result = 0;
		int location = 0, start = 0, end = 0;
		double front = 0, back = 0;
		try {
			result = Double.valueOf(Pattern.toString());
			return result;
		} catch (Exception e) {
		}
		while (Pattern.indexOf(Character.toString(SIGN[0])) != -1
				|| Pattern.indexOf(Character.toString(SIGN[1])) != -1) {
			if (Pattern.charAt(0) == '-' && Pattern.indexOf("-", 1) == -1)
				break;
			for (int i = 0; i < Pattern.length(); i++) {
				if (Pattern.charAt(i) == '*') {
					location = Pattern.indexOf("*");
					for (int j = location - 1; j >= 0; j--) {// �ҵ��˺�ǰ�������
						if (Pattern.charAt(j) == '+'
								|| Pattern.charAt(j) == '%') {
							/*
							 * if (Pattern.charAt(j) == '-' && j == 0) {//
							 * �ж��Ƿ��Ը��ſ�ͷ start = 0; front =
							 * Double.valueOf(Pattern.substring(start,
							 * location)); break; }
							 */
							start = j + 1;
							front = Double.valueOf(Pattern.substring(start,
									location));
							break;
						} else if (Pattern.charAt(j) == '-') {
							start = j;
							front = Double.valueOf(Pattern.substring(start,
									location));
							break;
						} else if (j == 0) {
							start = 0;
							front = Double.valueOf(Pattern.substring(start,
									location));
							break;
						}
					}
					for (int j = location + 1; j < Pattern.length(); j++) {// �ҵ��˺ź��������
						if (Pattern.charAt(location + 1) == '-') {
							if (j == Pattern.length() - 1) {
								end = Pattern.length();
								back = Double.valueOf(Pattern
										.substring(location + 1));
								break;
							} else if (Pattern.charAt(j + 1) == '+'
									|| Pattern.charAt(j + 1) == '-') {
								end = j + 1;
								back = Double.valueOf(Pattern.substring(
										location + 1, end));
								break;
							}
						} else {
							if (Pattern.charAt(j) == '+'
									|| Pattern.charAt(j) == '-'
									|| Pattern.charAt(j) == '*'
									|| Pattern.charAt(j) == '/'
									|| Pattern.charAt(j) == '%') {
								end = j;
								back = Double.valueOf(Pattern.substring(
										location + 1, end));
								break;
							} else if (j == Pattern.length() - 1) {
								end = Pattern.length();
								back = Double.valueOf(Pattern
										.substring(location + 1));
								break;
							}
						}
					}
					switch (Pattern.charAt(location)) {
					case '*':
						result = front * back;
						Pattern.replace(start, end, Double.toString(result));
						break;
					case '/':
						result = front / back;
						Pattern.replace(start, end, Double.toString(result));
						break;
					}
				} else if (Pattern.charAt(i) == '/') {
					location = Pattern.indexOf("/");
					for (int j = location - 1; j >= 0; j--) {// �ҵ��˺�ǰ�������
						if (Pattern.charAt(j) == '+'
								|| Pattern.charAt(j) == '%') {
							/*
							 * if (Pattern.charAt(j) == '-' && j == 0) {//
							 * �ж��Ƿ��Ը��ſ�ͷ start = 0; front =
							 * Double.valueOf(Pattern.substring(start,
							 * location)); break; }
							 */
							start = j + 1;
							front = Double.valueOf(Pattern.substring(start,
									location));
							break;
						} else if (Pattern.charAt(j) == '-') {
							start = j;
							front = Double.valueOf(Pattern.substring(start,
									location));
							break;
						} else if (j == 0) {
							start = 0;
							front = Double.valueOf(Pattern.substring(start,
									location));
							break;
						}
					}
					for (int j = location + 1; j < Pattern.length(); j++) {// �ҵ��˺ź��������
						if (Pattern.charAt(location + 1) == '-') {
							if (j == Pattern.length() - 1) {
								end = Pattern.length();
								back = Double.valueOf(Pattern
										.substring(location + 1));
								break;
							} else if (Pattern.charAt(j + 1) == '+'
									|| Pattern.charAt(j + 1) == '-') {
								end = j + 1;
								back = Double.valueOf(Pattern.substring(
										location + 1, end));
								break;
							}
						} else {
							if (Pattern.charAt(j) == '+'
									|| Pattern.charAt(j) == '-'
									|| Pattern.charAt(j) == '*'
									|| Pattern.charAt(j) == '/'
									|| Pattern.charAt(j) == '%') {
								end = j;
								back = Double.valueOf(Pattern.substring(
										location + 1, end));
								break;
							} else if (j == Pattern.length() - 1) {
								end = Pattern.length();
								back = Double.valueOf(Pattern
										.substring(location + 1));
								break;
							}
						}
					}
					switch (Pattern.charAt(location)) {
					case '*':
						result = front * back;
						Pattern.replace(start, end, Double.toString(result));
						break;
					case '/':
						result = front / back;
						Pattern.replace(start, end, Double.toString(result));
						break;
					}
				}
			}

		}
		for (int i = 2; i < 5; i++) {
			while (Pattern.indexOf(Character.toString(SIGN[i])) != -1) {// ���μ�����ʽ�и�������
				if (Pattern.charAt(0) == '-' && Pattern.indexOf("-", 1) == -1
						&& Pattern.indexOf("+") == -1)
					break;
				location = Pattern.indexOf(Character.toString(SIGN[i]), 1);
				for (int j = location - 1; j >= 0; j--) {// �ҵ��˺�ǰ�������
					if (Pattern.charAt(j) == '+') {
						if (Pattern.charAt(j) == '-' && j == 0) {// �ж��Ƿ��Ը��ſ�ͷ
							start = 0;
							front = Double.valueOf(Pattern.substring(start,
									location));
							break;
						}

						start = j + 1;
						front = Double.valueOf(Pattern.substring(start,
								location));
						break;
					} else if (Pattern.charAt(j) == '-') {
						start = j;
						front = Double.valueOf(Pattern.substring(start,
								location));
						break;
					} else if (j == 0) {
						start = 0;
						front = Double.valueOf(Pattern.substring(start,
								location));
						break;
					}
				}
				// System.out.println(front);//
				for (int j = location + 1; j < Pattern.length(); j++) {// �ҵ��˺ź��������
					if (Pattern.charAt(location + 1) == '-') {
						if (j == Pattern.length() - 1) {
							end = Pattern.length();
							back = Double.valueOf(Pattern
									.substring(location + 1));
							break;
						} else if (Pattern.charAt(j + 1) == '+'
								|| Pattern.charAt(j + 1) == '-') {
							end = j + 1;
							back = Double.valueOf(Pattern.substring(
									location + 1, end));
							break;
						}
					} else {
						if (Pattern.charAt(j) == '+'
								|| Pattern.charAt(j) == '-'
								// || Pattern.charAt(j) == '*'
								// || Pattern.charAt(j) == '/'
								|| Pattern.charAt(j) == '%') {
							end = j;
							back = Double.valueOf(Pattern.substring(
									location + 1, end));
							break;
						} else if (j == Pattern.length() - 1) {
							end = Pattern.length();
							back = Double.valueOf(Pattern
									.substring(location + 1));
							break;
						}
					}
				}
				// System.out.println(back);
				// ���㲢�滻���ʽ�е�����
				switch (i) {
				case 2:
					result = front % back;
					Pattern.replace(start, end, Double.toString(result));
					break;
				case 3:
					result = front + back;
					Pattern.replace(start, end, Double.toString(result));
					break;
				case 4:
					result = front - back;
					Pattern.replace(start, end, Double.toString(result));
					break;
				}
			}
		}
		return result;
	}

	private double solvePow(StringBuffer Pattern) {
		int num = 0, location;
		int start = 0, end = 0;
		double result = 0;

		while (hasPow(Pattern)) {
			// System.out.println(Pattern);
			location = Pattern.indexOf("^");
			if (Pattern.charAt(location - 1) == ')') {
				// ^֮ǰ������
				for (int i = location - 1; i >= 0; i--) {
					if (Pattern.charAt(i) == '(' || Pattern.charAt(i) == '��') {
						num++;
						if (num == 0)
							start = i;
					}
					if (Pattern.charAt(i) == ')' || Pattern.charAt(i) == '��') {
						if (num == 0)
							end = i;
						num--;
					}
				}
				if (hasPow(Pattern.substring(start + 1, end))) {
					Pattern.replace(start, end + 1, solvePow(new StringBuffer(
							Pattern.substring(start + 1, end))) + "");
				} else {
					Pattern.replace(
							start,
							end + 1,
							solveComplex(new StringBuffer(Pattern.substring(
									start + 1, end))) + "");
				}
			}
			location = Pattern.indexOf("^");
			if (Pattern.charAt(location + 1) == '(') {
				// ^֮�������
				for (int i = location + 1; i < Pattern.length(); i++) {
					if (Pattern.charAt(i) == '(' || Pattern.charAt(i) == '��') {
						if (num == 0)
							start = i;
						num++;
					}
					if (Pattern.charAt(i) == ')' || Pattern.charAt(i) == '��') {
						num--;
						if (num == 0)
							end = i;
					}
				}
				if (hasPow(Pattern.substring(start + 1, end))) {
					Pattern.replace(start, end + 1, solvePow(new StringBuffer(
							Pattern.substring(start + 1, end))) + "");
				} else {
					Pattern.replace(
							start,
							end + 1,
							solveComplex(new StringBuffer(Pattern.substring(
									start + 1, end))) + "");
				}
			}
			//System.out.println(Pattern);
			location = Pattern.indexOf("^");
			start = 0;
			end = 0;
			for (int i = location - 1; i >= 0; i--) {
				if (!Character.isDigit(Pattern.charAt(i))
						&& Pattern.charAt(i) != '.') {
					start = i + 1;
					break;
				} else if (i == 0) {
					start = 0;
					break;
				}
			}
			for (int i = location + 1; i < Pattern.length(); i++) {
				if (!Character.isDigit(Pattern.charAt(i))
						&& Pattern.charAt(i) != '.') {
					end = i;
					break;
				} else if (i == Pattern.length() - 1 && end == 0) {
					end = Pattern.length();
					break;
				}
			}
			Pattern.replace(
					start,
					end,
					Math.pow(
							Double.valueOf(Pattern.substring(start, location)),
							Double.valueOf(Pattern.substring(location + 1, end)))
							+ "");
		}
		// System.out.println(result);
		return result;
	}

	private double solveComplex(StringBuffer Pattern) {
		int num = 0;
		int start = 0, end = 0;
		double result = 0;
		while (hasParenthese(Pattern) || hasFunction(Pattern)) {
			System.out.println(Pattern);
			for (int i = 0; i < Pattern.length(); i++) {
				if (Pattern.charAt(i) == '(' || Pattern.charAt(i) == '��') {
					if (num == 0)
						start = i + 1;
					num++;
				}
				if (Pattern.charAt(i) == ')' || Pattern.charAt(i) == '��') {
					num--;
					if (num == 0)
						end = i;
				}
			}
			if (start == 1) {
				Pattern.replace(0, end + 1, solveComplex(new StringBuffer(
						Pattern.substring(start, end))) + "");
			} else {
				if (start - 4 >= 0
						&& Pattern.substring(start - 4, start - 1)
								.equalsIgnoreCase(sin)) {// ����sin
					if (mode) {
						Pattern.replace(
								start - 4,
								end + 1,
								Math.sin(solveComplex(new StringBuffer(Pattern
										.substring(start, end)))) + "");
					} else {
						Pattern.replace(
								start - 4,
								end + 1,
								Math.sin(Math
										.toRadians(solveComplex(new StringBuffer(
												Pattern.substring(start, end)))))
										+ "");
					}
				} else if (start - 4 >= 0
						&& Pattern.substring(start - 4, start - 1)
								.equalsIgnoreCase(cos)) {// ����cos
					if (mode) {
						Pattern.replace(
								start - 4,
								end + 1,
								Math.cos(solveComplex(new StringBuffer(Pattern
										.substring(start, end)))) + "");
					} else {
						Pattern.replace(
								start - 4,
								end + 1,
								Math.cos(Math
										.toRadians(solveComplex(new StringBuffer(
												Pattern.substring(start, end)))))
										+ "");

					}
				} else if (start - 4 >= 0
						&& Pattern.substring(start - 4, start - 1)
								.equalsIgnoreCase(tan)) {// ����tan
					if (mode) {
						Pattern.replace(
								start - 4,
								end + 1,
								Math.tan(solveComplex(new StringBuffer(Pattern
										.substring(start, end)))) + "");
					} else {
						Pattern.replace(
								start - 4,
								end + 1,
								Math.tan(Math
										.toRadians(solveComplex(new StringBuffer(
												Pattern.substring(start, end)))))
										+ "");
					}
				} else if (start - 4 >= 0
						&& Pattern.substring(start - 4, start - 1)
								.equalsIgnoreCase(abs)) {// ����abs
					Pattern.replace(
							start - 4,
							end + 1,
							Math.abs(solveComplex(new StringBuffer(Pattern
									.substring(start, end)))) + "");
				} else {
					Pattern.replace(
							start - 1,
							end + 1,
							solveComplex(new StringBuffer(Pattern.substring(
									start, end))) + "");
				}
				// System.out.println(Pattern);
			}
		}
		result = solveSimple(Pattern);
		// System.out.println(result);
		return result;
	}

	private StringBuffer OPattern = new StringBuffer();// ԭʼ����ѧ���ʽ
}
